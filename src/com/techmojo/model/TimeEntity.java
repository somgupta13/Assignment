package com.techmojo.model;

import java.util.Date;

public class TimeEntity {
    private String tid;
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }
    public TimeEntity setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }
    public Date getEndTime() {
        return endTime;
    }
    public TimeEntity setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }
    public String getTid() {
        return tid;
    }

    public TimeEntity setTid(String tid) {
        this.tid = tid;
        return this;
    }
}
