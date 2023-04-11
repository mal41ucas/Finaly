package com.example.Model;

import android.graphics.drawable.Drawable;

public class Car {
    Drawable image;

    public Car(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
