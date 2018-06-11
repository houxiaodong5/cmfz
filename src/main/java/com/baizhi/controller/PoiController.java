package com.baizhi.controller;

import com.baizhi.entity.FileParam;
import com.baizhi.entity.User;

import com.baizhi.service.UserService;
import com.baizhi.util.UploadUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */
@Controller
@RequestMapping("/poi")
public class PoiController {    //要导出的字段   对应的属性名    导出时用流写出
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping("/customerExport")

    public void customerExport(String titles, String fileds, HttpServletResponse response) {
        //获取所有的标题
        String[] title = titles.split(",");
        //获取标签对应的属性
        String[] allFiled = fileds.split(",");
        //创建工作簿（.xls）
        Workbook workbook = new HSSFWorkbook();

        //指定日期输出格式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        Sheet sheet = workbook.createSheet("工作表");
        //创建首行 （标题行）
        Row row = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            String s = title[i];
            Cell cell = row.createCell(i);//创建单元格
            cell.setCellValue(s);//将标题插入单元格
        }

        //数据行
        List<User> users=userService.queryAll();
        for (int i = 0; i < users.size(); i++) {
            //定义数据的行数
            Row dataRow = sheet.createRow(i+1);
            for (int j = 0; j < allFiled.length; j++) {
                Cell cell = dataRow.createCell(j);
                Class<? extends User> userClass = users.get(i).getClass();
                String methodName="get"+allFiled[j].substring(0,1).toUpperCase()+allFiled[j].substring(1);
                try {
                    Object invoke = userClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                    if(invoke  instanceof Date){
                        sheet.setColumnWidth(j,18*256);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    }else {
                        cell.setCellValue(invoke.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String name="自定义导出数据.xls";
        String fileName="";
        try {
            fileName = new String(name.getBytes("UTF-8"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        response.setContentType("application/vnd.ms-excel");
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/importFile")
   public  void importFile(MultipartFile importFile, HttpServletRequest request){
        //文件上传  将文件存在文件服务器下
        FileParam fileParam = UploadUtil.uploadFile(importFile, request, UploadUtil.FILE);

        List<User> list=new ArrayList<User>();

        try {
            //创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("F:\\apache-tomcat-7.0.67\\webapps"+fileParam.getUrl()));
            //获取工作表
            HSSFSheet sheet = workbook.getSheet("工作表");
            //声明行对象
            HSSFRow row=null;
            User user=null;
            //获取数据行
            for (int i=1;i<=sheet.getLastRowNum();i++){
                user=new User();
                row=sheet.getRow(i);
                System.out.println(row.getCell(1).getStringCellValue());
                String s=row.getCell(1).getStringCellValue();
                user.setPhoneNum(row.getCell(1).getStringCellValue());
                user.setUsername(row.getCell(2).getStringCellValue());
                user.setPassword(row.getCell(3).getStringCellValue());
                user.setDharmaName(row.getCell(5).getStringCellValue());
                user.setProvince(row.getCell(6).getStringCellValue());
                user.setCity(row.getCell(7).getStringCellValue());
               // user.setLocation(row.getCell(8).getStringCellValue());
                user.setSex(row.getCell(9).getStringCellValue());
                user.setSign(row.getCell(10).getStringCellValue());
                user.setStatus(row.getCell(11).getStringCellValue());
                user.setRegDate(row.getCell(12).getDateCellValue());
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list.size()!=0){
            userService.insertAll(list);
        }
    }
}

















