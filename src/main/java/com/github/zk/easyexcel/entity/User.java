package com.github.zk.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import org.apache.tomcat.util.modeler.BaseModelMBean;

/**
 * @author zk
 * @date 2019/5/14 12:28
 */
public class User extends BaseRowModel {
    @ExcelProperty(value = {"id","id1"} ,index = 0)
    private int id1;

    @ExcelProperty(value = {"id","id2"} ,index = 1)
    private int id2;

    @ExcelProperty(value = {"姓名","姓名"} ,index = 2)
    private String name;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
