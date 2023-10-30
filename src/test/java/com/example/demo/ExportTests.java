package com.example.demo;




import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.vo.BaseEntityTypeConstants;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 功能描述 : easy-opi 导出功能
 * @author guoyiguang
 * @date 2022/12/28
 * @param
 * @return
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ExportTests {







    /**
     * 功能描述 ：
     * @author guoyiguang
     * @date 2022/12/28
     * @param
     * @return
     */
    @SneakyThrows
    @Test
    public void testLocalDateTime() {


        // Map作为每一行的数据容器，List作为行的容器
        List<Map<String, Object>> rowDataList = new ArrayList<>();

        // 每个ExcelExportEntity存放Map行数据的key
        List<ExcelExportEntity> keyList = new ArrayList<>();


        Map<String, Object> map =  new HashMap<>();
        map.put("Username","赵公明1");
        map.put("sex","男");
        map.put("BornDate",new Date());
        rowDataList.add(map);


        Map<String, Object> map2 =  new HashMap<>();
        map2.put("Username","赵公明2");
        map2.put("sex","男");
        map2.put("BornDate",new Date());
        List<Map<String,Object>> objects = new ArrayList<>();
        Map<String, Object> sonMap =  new HashMap<>();
        sonMap.put("Username","赵公明_儿子");
        sonMap.put("sex","男");
        objects.add(sonMap);
        // 放另一个
        map2.put("sonList",objects);
        rowDataList.add(map2);

        System.out.println(rowDataList);

        ExcelExportEntity username = new ExcelExportEntity("姓名", "Username");
        keyList.add(username);

//        ExcelExportEntity sex = new ExcelExportEntity("性别", "Sex");
//        sex.setReplace(new String[]{"男_true","女_false"});
//        keyList.add(sex);

        ExcelExportEntity bornDate = new ExcelExportEntity("出生年月", "BornDate");
        //设置导出日期格式
        bornDate.setFormat("yyyy-MM-dd");
        keyList.add(bornDate);


        ExcelExportEntity headImage = new ExcelExportEntity("图像", "HeadImage");
        //此处是设置图片
        headImage.setExportImageType(1);  //设置导出图片类型是文件
        headImage.setType(BaseEntityTypeConstants.IMAGE_TYPE);  //设置类型是图片
        keyList.add(headImage);

        //
        String fileName = "D:\\abc.xls";
        exportOneSheet(fileName,keyList,rowDataList);


    }

    public void  exportOneSheet(String fileName,List<ExcelExportEntity> keyList,List<Map<String, Object>> rowDataList) throws IOException {

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                keyList, rowDataList);

        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();

    }


    @Test
    public  void log(){

        Map f = new HashMap();
        f.put("name","单位");
        f.put("uid","1");
        f.put("parent_uid","0");

        Map son = new HashMap();
        son.put("name","单位_SON");
        son.put("uid","2");
        son.put("parent_uid","1");


        Map f2 = new HashMap();
        f2.put("name","单位");
        f2.put("uid","3");
        f2.put("parent_uid","0");

        Map son2 = new HashMap();
        son2.put("name","单位_SON");
        son2.put("uid","4");
        son2.put("parent_uid","3");


        Map son3 = new HashMap();
        son3.put("name","单位_SON_2");
        son3.put("uid","5");
        son3.put("parent_uid","2");

        List<Map> list = new ArrayList<>();
        list.add(f);
        list.add(son);
        list.add(f2);
        list.add(son2);
        list.add(son3);

        // 获取root

        List<Map> rootList = list.stream().filter(e -> e.get("parent_uid").toString().equals("0")).collect(Collectors.toList());
        List<Map> factoryTree = getFactoryTree(rootList, list);
        System.out.println(factoryTree);


    }




    @Test
    public  void logLikeQuery(){


        if("123".equals(null)){
            System.out.println("");
        }

        Map f = new HashMap();
        f.put("name","单位");
        f.put("uid","1");
        f.put("parent_uid","0");

        Map son = new HashMap();
        son.put("name","单位_");
        son.put("uid","2");
        son.put("parent_uid","1");

        Map son3 = new HashMap();
        son3.put("name","单位_SON_2");
        son3.put("uid","5");
        son3.put("parent_uid","2");


        Map f2 = new HashMap();
        f2.put("name","工厂");
        f2.put("uid","3");
        f2.put("parent_uid","0");

        Map son2 = new HashMap();
        son2.put("name","工厂_JE");
        son2.put("uid","4");
        son2.put("parent_uid","3");




        List<Map> list = new ArrayList<>();
        list.add(f);
        list.add(son);
        list.add(f2);
        list.add(son2);
        list.add(son3);

        // 获取root
        List<Map> rootList = list.stream().filter(e -> e.get("parent_uid").toString().equals("0")).collect(Collectors.toList());

        // ① 模糊查询 ： 目标 SON
       // List<Map> targetDataList = list.stream().filter(e -> e.get("name").toString().contains("SON")).collect(Collectors.toList());
        List<Map> targetDataList = list.stream().filter(e -> e.get("name").toString().contains("JE")).collect(Collectors.toList());

        // ② 找根
        Set<Map> targetParentSet  = new HashSet<>();

        getRootList(targetDataList, list,  targetParentSet);

        //
        List<Map>  list0 = new ArrayList<>();
        for(Map map :targetParentSet){
            if(!list0.contains(map)){
                list0.add(map);
            }
        }
        for(Map map :targetDataList){
            if(!list0.contains(map)){
                list0.add(map);
            }
        }

        List<Map> likeRootList = list0.stream().filter(e -> e.get("parent_uid").toString().equals("0")).collect(Collectors.toList());

        List<Map> factoryTree = getFactoryTree(likeRootList, list0);

        //System.out.println(factoryTree);
        System.out.println(factoryTree);


    }


    public  List<Map>  getFactoryTree(List<Map> rootList ,List<Map> allFactories){

        if(CollectionUtils.isEmpty(rootList)){
             return new ArrayList<>();
        }

        for(Map root : rootList){
            List<Map> sonList = allFactories.stream().filter(e -> e.get("parent_uid").toString().equals(root.get("uid").toString())).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(sonList)){
                root.put("children",sonList);
                getFactoryTree(sonList, allFactories);
            }

        }
          return rootList;

    }


    public  Set<Map>  getRootList(List<Map> sonList ,List<Map> allFactories,Set<Map> targetParentSet){

        if(CollectionUtils.isEmpty(sonList)){
            return targetParentSet;
        }

        for(Map son : sonList){
            List<Map> patentList = allFactories.stream().filter(e -> e.get("uid").toString().equals(son.get("parent_uid").toString())).collect(Collectors.toList());

            if(!CollectionUtils.isEmpty(patentList) && null !=patentList.get(0) && !targetParentSet.contains(patentList.get(0)) ){
                targetParentSet.add(patentList.get(0));
            }
            getRootList(patentList, allFactories,targetParentSet);

        }
        return targetParentSet;

    }




}
