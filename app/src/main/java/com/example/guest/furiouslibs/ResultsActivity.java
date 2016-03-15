package com.example.guest.furiouslibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    public static final String TAG = ResultsActivity.class.getSimpleName();
    private TextView mResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mResultsTextView = (TextView) findViewById(R.id.resultsTextView);

        Intent intent = getIntent();
        String yourName = intent.getStringExtra("yourName");
        String preferredPronoun = intent.getStringExtra("preferredPronoun");
        String pluralNounOne = intent.getStringExtra("pluralNounOne");
        String adjectiveOne = intent.getStringExtra("adjectiveOne");
        String professionOne = intent.getStringExtra("professionOne");

        String furiousLibStringFormat = getResources().getString(R.string.madlib_1);

        String furiousLibsMessage = String.format(furiousLibStringFormat, yourName, preferredPronoun, adjectiveOne, pluralNounOne, professionOne);
        mResultsTextView.setText(furiousLibsMessage);


    }
}
