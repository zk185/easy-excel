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
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
}
