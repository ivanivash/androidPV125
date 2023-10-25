package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText inputField;
    private String currentInput = "";
    private String operator = "";
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = findViewById(R.id.inputField);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        inputField.setText(currentInput);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        if (!currentInput.isEmpty()) {
            operator = button.getText().toString();
            result = Double.parseDouble(currentInput);
            currentInput = "";
        }
    }

    public void onEqualClick(View view) {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double operand = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        // Обробка помилки: ділення на нуль
                        inputField.setText("Error");
                        return;
                    }
                    break;
            }
            currentInput = Double.toString(result);
            inputField.setText(currentInput);
            operator = "";
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        operator = "";
        result = 0;
        inputField.setText("");
    }
}
