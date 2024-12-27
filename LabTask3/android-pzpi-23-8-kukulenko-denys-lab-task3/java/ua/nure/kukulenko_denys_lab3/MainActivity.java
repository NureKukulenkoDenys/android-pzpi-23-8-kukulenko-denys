package ua.nure.kukulenko_denys_lab3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText resultField;
    private double firstNum = 0;
    private String operation = "";
    private boolean newNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = findViewById(R.id.resultField);

        if (savedInstanceState != null) {
            resultField.setText(savedInstanceState.getString("resultField"));
            firstNum = savedInstanceState.getDouble("firstNum");
            operation = savedInstanceState.getString("operation");
            newNumber = savedInstanceState.getBoolean("newNumber");
        } else {
            resultField.setText("0");
        }

        int[] numberIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(v -> {
                Button button = (Button) v;
                numberClick(button.getText().toString());
            });
        }

        findViewById(R.id.btnPlus).setOnClickListener(v -> operationClick("+"));
        findViewById(R.id.btnMinus).setOnClickListener(v -> operationClick("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> operationClick("×"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> operationClick("÷"));
        findViewById(R.id.btnEquals).setOnClickListener(v -> Result());
        findViewById(R.id.btnClear).setOnClickListener(v -> clearCalculator());
        findViewById(R.id.btnDot).setOnClickListener(v -> addDecimalPoint());
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteLastCharacter());
        findViewById(R.id.btnPercent).setOnClickListener(v -> percent());
    }

    private void numberClick(String number) {
        if (newNumber) {
            resultField.setText(number);
            newNumber = false;
        } else {
            resultField.append(number);
        }
    }

    private void operationClick(String op) {
        firstNum = Double.parseDouble(resultField.getText().toString());
        operation = op;
        newNumber = true;
    }

    private void clearCalculator() {
        resultField.setText("0");
        firstNum = 0;
        operation = "";
        newNumber = true;
    }

    private void addDecimalPoint() {
        if (!resultField.getText().toString().contains(".")) {
            resultField.append(".");
        }
    }

    private void deleteLastCharacter() {
        String currentText = resultField.getText().toString();
        if (currentText.length() > 1) {
            resultField.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            resultField.setText("0");
            newNumber = true;
        }
    }

    private void percent() {
        if (!operation.isEmpty()) {
            double currentNum = Double.parseDouble(resultField.getText().toString());
            double percentage = (firstNum * currentNum) / 100;
            resultField.setText(formatResult(percentage));
            newNumber = true;
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format(Locale.US, "%d", (long) result);
        } else {
            return String.format(Locale.US, "%.2f", result);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultField", resultField.getText().toString());
        outState.putDouble("firstNum", firstNum);
        outState.putString("operation", operation);
        outState.putBoolean("newNumber", newNumber);
    }

    private void Result() {
        if (operation.isEmpty()) return;

        double secondNum = Double.parseDouble(resultField.getText().toString());
        double result = 0;

        switch (operation) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "×":
                result = firstNum * secondNum;
                break;
            case "÷":
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                } else {
                    resultField.setText("Error");
                    return;
                }
                break;
        }

        resultField.setText(formatResult(result));
        operation = "";
        newNumber = true;
    }
}