package com.dwh.bi.provider.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class DataSourceVO {

    private String name;

    private String ip;

    private String port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public DataSourceVO(String name, String ip, String port) {
        this.name = name;
        this.ip = ip;
        this.port = port;
    }
}
