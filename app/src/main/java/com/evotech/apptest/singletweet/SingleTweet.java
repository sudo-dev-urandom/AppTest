package com.evotech.apptest.singletweet;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleTweet implements Serializable
{

    @SerializedName("data")
    @Expose
    private Data data;
    private final static long serialVersionUID = 5086356264261011695L;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}