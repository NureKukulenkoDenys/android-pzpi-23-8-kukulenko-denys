package ua.nure.kukulenko_denis_pract_task2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.TypedValue;
import android.graphics.Typeface;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
    }
    public void Buttonclicked(View view){
        textView.setText("Кнопка натиснута");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        textView.setTypeface(null, Typeface.ITALIC);

    }
}