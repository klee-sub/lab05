package com.example.fourbasicopt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText first = findViewById(R.id.first);
        EditText second = findViewById(R.id.second);
        TextView result = findViewById(R.id.result);
        for (int id : new int[]{R.id.add, R.id.subtract, R.id.multiply, R.id.divide}) {
            findViewById(id).setOnClickListener(v -> {
                try {
                    double value = Calculator.calculate(
                            Double.parseDouble(first.getText().toString()),
                            Double.parseDouble(second.getText().toString()),
                            ((Button) v).getText().toString());
                    result.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    result.setText(R.string.invalid_input);
                } catch (ArithmeticException e) {
                    result.setText(R.string.division_by_zero);
                }
            });
        }
    }
}
