package com.teacat.interactivestory.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teacat.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private Button mStartButton;

    private String mName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign Views
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startAdventureButton);

        // Declare Listeners
        View.OnClickListener startListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mName = mNameEditText.getText().toString();
                startStory();
            }
        };
        mStartButton.setOnClickListener(startListener);



    }

    @Override
    protected void onResume(){
        super.onResume();
        mNameEditText.setText("");
    }

    private void startStory() {
        Intent startStoryIntent = new Intent(getApplicationContext(), StoryActivity.class);
        startStoryIntent.putExtra(getString(R.string.key_name), mName);
        startActivity(startStoryIntent);
    }
}
