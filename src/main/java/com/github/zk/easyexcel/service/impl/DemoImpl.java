package com.github.zk.easyexcel.service.impl;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.zk.easyexcel.entity.User;
import com.github.zk.easyexcel.service.IDemo;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zk
 * @date 2019/5/14 10:13
 */
@Service
public class DemoImpl implements IDemo {
    @Override
    public Sheet createSheet() {
        //初始化工作簿
        Sheet sheet = new Sheet(1,0, User.class);
        //未工作簿命名
        sheet.setSheetName("第一个sheet");
        return sheet;
    }

    @Override
    public List<User> getList() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
             User user = new User();
             user.setId1(i);
             user.setId2(i+1);
             user.setName("aa" + i);
             list.add(user);
        }
        return list;
    }

    public List<List<String>> getListStr() {
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            List<String> listChild = new ArrayList<>();
            listChild.add("a");
            listChild.add(i + "");
            listChild.add("b");
            list.add(listChild);
        }
        return list;
    }
}
