package com.evotech.apptest.singletweet;


import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities implements Serializable
{

    @SerializedName("urls")
    @Expose
    private List<Url> urls = null;
    private final static long serialVersionUID = -951198596448197972L;

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

}