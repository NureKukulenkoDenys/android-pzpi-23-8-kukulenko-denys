package ua.nure.kukulenkodenispract_task_2_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("Activity2", "onCreate called");

        Button finishButton = findViewById(R.id.button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity2", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity2", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity2", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity2", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity2", "onDestroy called");
    }
}