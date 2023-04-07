package com.example.demo;




import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.vo.BaseEntityTypeConstants;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


/**
 * 功能描述 : easy-opi 导出功能
 * @author guoyiguang
 * @date 2022/12/28
 * @param
 * @return
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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




}
