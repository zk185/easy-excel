package com.github.zk.easyexcel.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.zk.easyexcel.entity.User;
import com.github.zk.easyexcel.service.IDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zk
 * @date 2019/5/14 10:09
 */
@RestController
public class DemoController {
    @Autowired
    private IDemo iDemo;
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletRequest request , HttpServletResponse response) {
        try {
            String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                    .getBytes(), "UTF-8");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
            ServletOutputStream out = response.getOutputStream();
            Sheet sheet = iDemo.createSheet();
            ExcelWriter writer = EasyExcelFactory.getWriter(out,ExcelTypeEnum.XLSX,true);

            //向工作簿中写入数据
            writer.write(iDemo.getList(),sheet);
            //合并第3行到第四行数据
            writer.merge(2,3,0,0);
            writer.finish();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/exportExcelTemplate")
    public void exportExcelTemplate() throws IOException {
        InputStream in = new FileInputStream("H:/aa.xlsx");
        OutputStream out = new FileOutputStream("H:/2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriterWithTemp(in,out,ExcelTypeEnum.XLSX,false);

        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 0, User.class);
        sheet1.setSheetName("第一个sheet");
        //or 设置自适应宽度
        sheet1.setAutoWidth(Boolean.TRUE);
        writer.write0(iDemo.getList(), sheet1, 3, 2,0);

        //关闭资源
        writer.finish();
        out.close();
    }

}
