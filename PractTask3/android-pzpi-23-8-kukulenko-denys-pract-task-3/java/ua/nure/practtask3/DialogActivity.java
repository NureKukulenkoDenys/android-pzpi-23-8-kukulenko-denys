package ua.nure.practtask3;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.buttonAlertDialog).setOnClickListener(v -> {
            new AlertDialog.Builder(DialogActivity.this)
                    .setTitle("Alert Dialog")
                    .setMessage("This is an example of AlertDialog.")
                    .setPositiveButton("OK", (dialog, which) ->
                            Toast.makeText(DialogActivity.this, "OK clicked", Toast.LENGTH_SHORT).show())
                    .setNegativeButton("Cancel", (dialog, which) ->
                            Toast.makeText(DialogActivity.this, "Cancel clicked", Toast.LENGTH_SHORT).show())
                    .show();
        });

        findViewById(R.id.buttonDatePickerDialog).setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DialogActivity.this, (view, year, month, dayOfMonth) -> {
                Toast.makeText(DialogActivity.this, "Ви обрали дату: " + dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
            }, 2023, 0, 1);
            datePickerDialog.show();
        });

        findViewById(R.id.buttonCustomDialog).setOnClickListener(v -> {
            EditText editText = new EditText(DialogActivity.this);
            editText.setHint("Введіть текст");
            new AlertDialog.Builder(DialogActivity.this)
                    .setTitle("Custom Dialog")
                    .setView(editText)
                    .setPositiveButton("OK", (dialog, which) -> {
                        String input = editText.getText().toString();
                        Toast.makeText(DialogActivity.this, "Введено: " + input, Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}
