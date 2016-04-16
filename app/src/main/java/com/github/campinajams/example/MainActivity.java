package com.github.campinajams.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_OPEN_SETTINGS = 1;

    private TextView greetingLabel;
    private TextView noSavedItemsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingLabel = (TextView) findViewById(R.id.greeting);
        noSavedItemsLabel = (TextView) findViewById(R.id.no_saved_items);
        noSavedItemsLabel.setSelected(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), NameDialog.class);
            startActivityForResult(intent, REQUEST_OPEN_SETTINGS);
            return true;
        }
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_OPEN_SETTINGS) {
            if (resultCode == RESULT_OK) {
                String newName = data.getStringExtra(NameDialog.KEY_NEW_NAME);
                String newGreeting;
                if (newName == null || newName.trim().isEmpty()) {
                    newGreeting = getString(R.string.hello_world);
                } else {
                    newGreeting = String.format(getString(R.string.hello_person), newName);
                }
                greetingLabel.setText(newGreeting);
            }
        }
    }

}
