package com.teacat.interactivestory.UI;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teacat.interactivestory.Model.Page;
import com.teacat.interactivestory.Model.Story;
import com.teacat.interactivestory.R;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();

    String mName;
    private Story mStory;
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1Button;
    private Button mChoice2Button;
    private Stack<Integer> pageStack = new Stack<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1Button = (Button) findViewById(R.id.choice1Button);
        mChoice2Button = (Button) findViewById(R.id.choice2Button);

        // Retrieve intent
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if(mName == null || mName.isEmpty()){
            mName = "User";
        }
        Log.d(TAG,mName);

        mStory = new Story();
        loadPage(0);


    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);

       final Page page = mStory.getPage(pageNumber);
        mImageView.setImageResource(page.getmImageId());
        String pageText = getString(page.getmStringId());
        pageText = String.format(pageText,mName); // add name if necessary
        mTextView.setText(pageText);

        if (page.getmIsFinalPage()){
            mChoice1Button.setVisibility(View.INVISIBLE);
            mChoice2Button.setText(R.string.play_again_button_text);
            View.OnClickListener choice2Listener = new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    mChoice1Button.setVisibility(View.VISIBLE);
                    finish();
                }
            };
            mChoice2Button.setOnClickListener(choice2Listener);
        }
        else{
            mChoice1Button.setText(page.getmChoice1().getmTextId());
            mChoice2Button.setText(page.getmChoice2().getmTextId());

            // Set clicking behavior
            View.OnClickListener choice1Listener = new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    loadPage(page.getmChoice1().getmNextPage());
                }
            };
            mChoice1Button.setOnClickListener(choice1Listener);

            View.OnClickListener choice2Listener = new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    loadPage(page.getmChoice2().getmNextPage());
                }
            };
            mChoice2Button.setOnClickListener(choice2Listener);
        }


    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()){
            super.onBackPressed();
        }
        else{
            loadPage(pageStack.pop());
        }

    }
}
