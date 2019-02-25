package android.example.inclassassignment05_lix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String str = intent.getStringExtra("Message");

        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setText(str);


    }
}