package com.dev.models;

import java.util.List;

public class Page {

    private List<?> data;
    private int totalRecords;
    private int totalPages;
    private String requestDateTime;

    public Page(List<?> data, int totalRecords, int totalPages, String requestDateTime) {
        this.data = data;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.requestDateTime = requestDateTime;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @Override
    public String toString() {
        return "Page{" +
                "data=" + data +
                ", totalRecords=" + totalRecords +
                ", totalPages=" + totalPages +
                ", requestDateTime=" + requestDateTime +
                '}';
    }
}
