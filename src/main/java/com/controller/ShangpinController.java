










package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shangpin")
public class ShangpinController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpinController.class);

    @Autowired
    private ShangpinService shangpinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShangjiaService shangjiaService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        params.put("shangpinDeleteStart",1);params.put("shangpinDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shangpinService.queryPage(params);

        //字典表数据转换
        List<ShangpinView> list =(List<ShangpinView>)page.getList();
        for(ShangpinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinEntity shangpin = shangpinService.selectById(id);
        if(shangpin !=null){
            //entity转view
            ShangpinView view = new ShangpinView();
            BeanUtils.copyProperties( shangpin , view );//把实体数据重构到view中

                //级联表
                ShangjiaEntity shangjia = shangjiaService.selectById(shangpin.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinEntity shangpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpin:{}",this.getClass().getName(),shangpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("商家".equals(role))
            shangpin.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShangpinEntity> queryWrapper = new EntityWrapper<ShangpinEntity>()
            .eq("shangjia_id", shangpin.getShangjiaId())
            .eq("shangpin_name", shangpin.getShangpinName())
            .eq("shangpin_types", shangpin.getShangpinTypes())
            .eq("Shangpin_kucun_number", shangpin.getShangpinKucunNumber())
            .eq("shangxia_types", shangpin.getShangxiaTypes())
            .eq("shangpin_delete", shangpin.getShangpinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinEntity shangpinEntity = shangpinService.selectOne(queryWrapper);
        if(shangpinEntity==null){
            shangpin.setShangxiaTypes(1);
            shangpin.setShangpinDelete(1);
            shangpin.setCreateTime(new Date());
            shangpinService.insert(shangpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinEntity shangpin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shangpin:{}",this.getClass().getName(),shangpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("商家".equals(role))
//            shangpin.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShangpinEntity> queryWrapper = new EntityWrapper<ShangpinEntity>()
            .notIn("id",shangpin.getId())
            .andNew()
            .eq("shangjia_id", shangpin.getShangjiaId())
            .eq("shangpin_name", shangpin.getShangpinName())
            .eq("shangpin_types", shangpin.getShangpinTypes())
            .eq("Shangpin_kucun_number", shangpin.getShangpinKucunNumber())
            .eq("shangxia_types", shangpin.getShangxiaTypes())
            .eq("shangpin_delete", shangpin.getShangpinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinEntity shangpinEntity = shangpinService.selectOne(queryWrapper);
        if("".equals(shangpin.getShangpinPhoto()) || "null".equals(shangpin.getShangpinPhoto())){
                shangpin.setShangpinPhoto(null);
        }
        if(shangpinEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shangpin.set
            //  }
            shangpinService.updateById(shangpin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ShangpinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShangpinEntity shangpinEntity = new ShangpinEntity();
            shangpinEntity.setId(id);
            shangpinEntity.setShangpinDelete(2);
            list.add(shangpinEntity);
        }
        if(list != null && list.size() >0){
            shangpinService.updateBatchById(list);
        }
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShangpinEntity> shangpinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShangpinEntity shangpinEntity = new ShangpinEntity();
//                            shangpinEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //商家 要改的
//                            shangpinEntity.setShangpinName(data.get(0));                    //商品名称 要改的
//                            shangpinEntity.setShangpinTypes(Integer.valueOf(data.get(0)));   //商品类型 要改的
//                            shangpinEntity.setShangpinPhoto("");//照片
//                            shangpinEntity.setShangpinKucunNumber(Integer.valueOf(data.get(0)));   //商品库存 要改的
//                            shangpinEntity.setShangpinOldMoney(data.get(0));                    //商品原价 要改的
//                            shangpinEntity.setShangpinNewMoney(data.get(0));                    //商品现价 要改的
//                            shangpinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            shangpinEntity.setShangpinDelete(1);//逻辑删除字段
//                            shangpinEntity.setShangpinContent("");//照片
//                            shangpinEntity.setCreateTime(date);//时间
                            shangpinList.add(shangpinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shangpinService.insertBatch(shangpinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shangpinService.queryPage(params);

        //字典表数据转换
        List<ShangpinView> list =(List<ShangpinView>)page.getList();
        for(ShangpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinEntity shangpin = shangpinService.selectById(id);
            if(shangpin !=null){


                //entity转view
                ShangpinView view = new ShangpinView();
                BeanUtils.copyProperties( shangpin , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(shangpin.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinEntity shangpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shangpin:{}",this.getClass().getName(),shangpin.toString());
        Wrapper<ShangpinEntity> queryWrapper = new EntityWrapper<ShangpinEntity>()
            .eq("shangjia_id", shangpin.getShangjiaId())
            .eq("shangpin_name", shangpin.getShangpinName())
            .eq("shangpin_types", shangpin.getShangpinTypes())
            .eq("Shangpin_kucun_number", shangpin.getShangpinKucunNumber())
            .eq("shangxia_types", shangpin.getShangxiaTypes())
            .eq("shangpin_delete", shangpin.getShangpinDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinEntity shangpinEntity = shangpinService.selectOne(queryWrapper);
        if(shangpinEntity==null){
            shangpin.setShangpinDelete(1);
            shangpin.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shangpin.set
        //  }
        shangpinService.insert(shangpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
