package com.company;

import java.util.Date;

public class FileProcess {
    private int rowId;
    private Date date;


    public int getRowId() {
        return rowId;
    }

    public Date getDate() {
        return date;
    }

    FileProcess(int rowId, Date date) {
        this.rowId = rowId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "rowId=" + rowId +
                ", date=" + date.toString();
    }
}
