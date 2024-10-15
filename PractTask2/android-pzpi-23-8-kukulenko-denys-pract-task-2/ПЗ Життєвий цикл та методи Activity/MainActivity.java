package ua.nure.kukulenkodenispract_task_2_2;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity1", "onCreate called");

        findViewById(R.id.button).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });

        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString("savedText");
            EditText editText = findViewById(R.id.editText);
            editText.setText(savedText);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity1", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity1", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity1", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity1", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Активність1", "onDestroy called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText editText = findViewById(R.id.editText);
        outState.putString("savedText", editText.getText().toString());
        Log.d("Активність1", "onSaveInstanceState called");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Активність1", "onRestoreInstanceState called");
    }
}