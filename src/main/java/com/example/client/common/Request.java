package com.example.client.common;

import javax.xml.bind.annotation.*;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2020/10/16
 * @since 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tableName","beginTime","endTime"
})
@XmlRootElement(name = "Request",namespace = "http://www.dexcoder.com/ws")

public class Request {
    @XmlElement(required = true,name = "table")
    private String tableName;
    @XmlElement(required = true)
    private String beginTime;
    @XmlElement(required = true)
    private String endTime;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
