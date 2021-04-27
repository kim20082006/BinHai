package com.binhai.dazi.bean;

import java.io.Serializable;

public class DaziBean implements Serializable {
    private int id;
    private String name;
    private String banji;
    private String ifpass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getIfpass() {
        return ifpass;
    }

    public void setIfpass(String ifpass) {
        this.ifpass = ifpass;
    }
}
