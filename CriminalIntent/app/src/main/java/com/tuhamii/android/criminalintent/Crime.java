package com.tuhamii.android.criminalintent;

import java.util.UUID;

/**
 * Created by rwx on 11/1/16.
 */

public class Crime {
    // Vars
    private UUID mID;
    private String mTitle;


    // constructor
    public Crime(){
        mID = UUID.randomUUID(); // Generate RandomeID
    }

    // Methods
    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
