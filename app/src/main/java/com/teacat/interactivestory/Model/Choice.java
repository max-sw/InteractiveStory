package com.teacat.interactivestory.Model;

public class Choice {
    private int mTextId;
    private int mNextPage;

    public Choice(int textId, int nextPage){
        mTextId =textId;
        mNextPage = nextPage;
    }

    public int getmTextId() {
        return mTextId;
    }

    public void setmTextId(int mTextId) {
        this.mTextId = mTextId;
    }

    public int getmNextPage() {
        return mNextPage;
    }

    public void setmNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }
}
