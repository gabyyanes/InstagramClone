package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("BScWaWhZ44K3V3ZKRzMK9MMmYiUOwi2vhH6amhi3")
                .clientKey("wN4VNIzYPoZMgmRHrggWhbAe19lzhzzB5BQIYcqM")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
