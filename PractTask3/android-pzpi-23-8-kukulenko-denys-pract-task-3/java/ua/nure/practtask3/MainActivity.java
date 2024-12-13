package ua.nure.practtask3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.buttonDialog).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, DialogActivity.class)));

        findViewById(R.id.buttonHandler).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, HandlerActivity.class)));

        findViewById(R.id.List).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, list.class)));





    }
}