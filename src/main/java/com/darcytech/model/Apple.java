package com.darcytech.model;

import com.darcytech.annotation.FruitColor;
import com.darcytech.annotation.FruitName;

/**
 * Created by GXL on 2016/10/13.
 */
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor= FruitColor.Color.RED)
    private String appleColor;


    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }


    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

}

