package com.tuhamii.android.geoquiz;

/**
 * Created by AbdullahTuhami on 10/1/16.
 */

public class Question {
    // Strings
    private int mTextResId;
    private boolean mAnswerTrue;


    // Getter
    public int getTextResId() {
        return mTextResId;
    }
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }


    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }
    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    // Constructor
    public Question (int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    // Methods



}
