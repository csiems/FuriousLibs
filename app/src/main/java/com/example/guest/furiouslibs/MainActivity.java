package com.example.guest.furiouslibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mSubmitButton;
    private EditText mYourName, mPluralNounOne, mAdjectiveOne, mProfessionOne;
    private RadioGroup mPreferredPronounGroup;
    private RadioButton mPreferredPronounButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYourName = (EditText) findViewById(R.id.yourName);
        mPluralNounOne = (EditText) findViewById(R.id.pluralNounOne);
        mAdjectiveOne = (EditText) findViewById(R.id.adjectiveOne);
        mProfessionOne = (EditText) findViewById(R.id.professionOne);
        mPreferredPronounGroup = (RadioGroup) findViewById(R.id.preferredPronoun);
        mSubmitButton = (Button) findViewById(R.id.submitButton);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = mPreferredPronounGroup.getCheckedRadioButtonId();
                mPreferredPronounButton = (RadioButton) findViewById(selectedId);

                String preferredPronoun = mPreferredPronounButton.getText().toString();
                String pluralNounOne = mPluralNounOne.getText().toString();
                String yourName = mYourName.getText().toString();
                String adjectiveOne = mAdjectiveOne.getText().toString();
                String professionOne = mProfessionOne.getText().toString();

                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("yourName", yourName);
                intent.putExtra("pluralNounOne", pluralNounOne);
                intent.putExtra("adjectiveOne", adjectiveOne);
                intent.putExtra("professionOne", professionOne);
                intent.putExtra("preferredPronoun", preferredPronoun);
                startActivity(intent);
            }
        });

    }
}
