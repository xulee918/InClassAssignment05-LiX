package android.example.inclassassignment05_lix;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String title;
    String message;
    private EditText titleEditText;
    private EditText messageEditText;
    private CheckBox checkBox;
    private Button sendMailButton;
    private Button launchActivityButton;
    private Button launchCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        sendMailButton = (Button) findViewById(R.id.send_mail_button);
        sendMailButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                titleEditText = (EditText) findViewById(R.id.title_editText);
                title = titleEditText.getText().toString();

                messageEditText = (EditText) findViewById(R.id.message_editText);
                message = messageEditText.getText().toString();

                checkBox = (CheckBox) findViewById(R.id.checkbox);
                final boolean onlySendTitle = checkBox.isChecked();
                if(onlySendTitle){
                    message = " ";
                }

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(Intent.EXTRA_TEXT,message);

                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

            }
        });

        launchActivityButton = (Button) findViewById(R.id.launch_activity_button);
        launchActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Message", "Insane in the Membrane");
                startActivity(intent);
            }

        });

        launchCameraButton = (Button) findViewById(R.id.launch_camera_button);
        launchCameraButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });



    }
}