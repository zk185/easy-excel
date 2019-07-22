package com.github.zk.easyexcel.service;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.github.zk.easyexcel.entity.User;

import java.io.OutputStream;
import java.util.List;

/**
 * @author zk
 * @date 2019/5/14 10:09
 */
public interface IDemo {
    Sheet createSheet();

    List<User> getList();

    List<List<String>> getListStr();
}
