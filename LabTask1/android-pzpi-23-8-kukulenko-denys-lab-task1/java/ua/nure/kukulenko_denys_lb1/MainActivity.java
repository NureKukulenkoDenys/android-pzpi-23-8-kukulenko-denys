package ua.nure.kukulenko_denys_lb1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("life cycle", "onCreate");

        TextView textView = findViewById(R.id.text_view);
        textView.setText("My first Lab");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life cycle", "onStart");
    }

    @Override
        protected void onResume() {
        super.onResume();
        Log.d("life cycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life cycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life cycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life cycle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life cycle", "onDestroy");
    }
}