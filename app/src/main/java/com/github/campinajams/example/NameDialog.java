package com.github.campinajams.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameDialog extends AppCompatActivity {

    public static final String KEY_NEW_NAME = "KEY_NEW_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_name);

        final EditText nameInputField = (EditText) findViewById(R.id.name_input_field);
        final Button nameSaveButton = (Button) findViewById(R.id.name_save_button);

        nameSaveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String newName = nameInputField.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_NEW_NAME, newName);

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }

        });
    }

}
