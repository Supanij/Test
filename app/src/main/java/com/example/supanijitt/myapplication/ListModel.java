package com.example.supanijitt.myapplication;

import java.util.List;

/**
 * Created by SupanijItt on 10/1/2015.
 */
public class ListModel{
    public String UserName;
    public int ImageUrl;
    public String ImageDesc;

    public ListModel(){
        super();
    }

    public ListModel(String UserName, int ImageUrl, String ImageDesc){
        super();
        this.UserName = UserName;
        this.ImageDesc = ImageDesc;
        this.ImageUrl = ImageUrl;
    }
}
