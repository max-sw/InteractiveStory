package com.teacat.interactivestory.Model;

public class Page {
    private int mImageId;
    private int mStringId;
    private  Choice mChoice1;
    private Choice mChoice2;
    private Boolean mIsFinalPage = false;

    public Page(int mImageId, int mStringId) {
        this.mImageId = mImageId;
        this.mStringId = mStringId;
        this.mIsFinalPage = true;
    }

    public Page(int imageId, int stringId, Choice choice1, Choice choice2){
        mImageId = imageId;
        mStringId = stringId;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public int getmStringId() {
        return mStringId;
    }

    public void setmStringId(int mStringId) {
        this.mStringId = mStringId;
    }

    public Choice getmChoice1() {
        return mChoice1;
    }

    public void setmChoice1(Choice mChoice1) {
        this.mChoice1 = mChoice1;
    }

    public Choice getmChoice2() {
        return mChoice2;
    }

    public void setmChoice2(Choice mChoice2) {
        this.mChoice2 = mChoice2;
    }

    public Boolean getmIsFinalPage() {
        return mIsFinalPage;
    }

    public void setmIsFinalPage(Boolean mIsFinalPage) {
        this.mIsFinalPage = mIsFinalPage;
    }
}
