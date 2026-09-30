package com.example.lab05calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.math.BigDecimal;

public class MainActivity extends Activity {
    private final Calculator calculator = new Calculator();
    private EditText firstInput, secondInput;
    private Spinner operator;
    private TextView resultView;
    private static final String[] SYMBOLS = {"+", "−", "×", "÷"};

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        View root = findViewById(R.id.root);
        root.setOnApplyWindowInsetsListener((view, insets) -> {
            view.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets;
        });
        root.requestApplyInsets();
        firstInput = findViewById(R.id.inputFirst);
        secondInput = findViewById(R.id.inputSecond);
        operator = findViewById(R.id.spinnerOperator);
        resultView = findViewById(R.id.textResult);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"+  더하기", "−  빼기", "×  곱하기", "÷  나누기"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operator.setAdapter(adapter);
        findViewById(R.id.buttonCalculate).setOnClickListener(view -> calculate());
        if (state != null) resultView.setText(state.getString("result", "숫자를 입력하고 계산하세요."));
    }

    private void calculate() {
        String first = firstInput.getText().toString().trim();
        String second = secondInput.getText().toString().trim();
        if (first.isEmpty() || second.isEmpty()) {
            resultView.setText("숫자 두 개를 모두 입력하세요.");
            return;
        }
        try {
            double x = Double.parseDouble(first), y = Double.parseDouble(second);
            if (!Double.isFinite(x) || !Double.isFinite(y)) throw new NumberFormatException();
            int selected = operator.getSelectedItemPosition();
            double result;
            switch (selected) {
                case 0: result = calculator.add(x, y); break;
                case 1: result = calculator.subtract(x, y); break;
                case 2: result = calculator.multiply(x, y); break;
                default: result = calculator.divide(x, y); break;
            }
            if (!Double.isFinite(result)) {
                resultView.setText("계산 가능한 숫자 범위를 초과했습니다.");
                return;
            }
            resultView.setText(format(x) + " " + SYMBOLS[selected] + " " + format(y)
                    + " = " + format(result));
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(secondInput.getWindowToken(), 0);
            firstInput.clearFocus();
            secondInput.clearFocus();
        } catch (NumberFormatException ex) {
            resultView.setText("올바른 숫자를 입력하세요.");
        }
    }

    private String format(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
    }

    @Override protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putString("result", resultView.getText().toString());
    }
}
