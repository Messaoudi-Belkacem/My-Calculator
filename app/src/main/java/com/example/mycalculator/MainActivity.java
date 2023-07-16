package com.example.mycalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.nfunk.jep.JEP;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView,textViewResult;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonPoint
        ,buttonEquals,buttonPlus,buttonMinus,buttonDivide,buttonTimes,buttonClear,buttonDelete;
    Boolean ans = true;
    RecyclerView operationsRecyclerView;
    ArrayList<Operation> operations = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
        OperationsRecyclerViewAdapter adapter = new OperationsRecyclerViewAdapter();
        adapter.setOperationArrayList(operations);
        operationsRecyclerView.setAdapter(adapter);
        operationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called when the text is being changed.
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (textView.getText() != "") {
                    buttonClear.setText("C");
                }
                JEP jep = new JEP();
                String expression = textView.getText().toString();
                if (!expression.isEmpty()) {
                    expression = expression.replace("×","*");
                    expression = expression.replace("÷","/");
                    if (expression.charAt(expression.length()-1) == '+' ||
                            expression.charAt(expression.length()-1) =='-' ||
                            expression.charAt(expression.length()-1) =='/' ||
                            expression.charAt(expression.length()-1) =='*') {
                        expression = expression.substring(0,expression.length()-1);
                    } else if (expression.charAt(0) == '+' ||
                            expression.charAt(0) =='-' ||
                            expression.charAt(0) =='/' ||
                            expression.charAt(0) =='*') {
                        expression = expression.substring(1);
                    }
                    jep.parseExpression(expression);
                    if (jep.hasError()) {
                        System.out.println("Error: " + jep.getErrorInfo());
                        Toast.makeText(getApplicationContext(), "Error: " + jep.getErrorInfo(), Toast.LENGTH_SHORT).show();
                    } else {
                        double result = jep.getValue();
                        if (Double.isInfinite(result)) {
                            textViewResult.setText("= Can't divide by zero");
                        } else if (Math.floor(result) == result) {
                            int intValue = (int) Math.floor(result);
                            textViewResult.setText("= " + intValue);
                        }
                        else {
                            textViewResult.setText("= " + result);
                        }
                    }
                }
            }
        });
    }
    protected void initialiseUI() {
        textView = findViewById(R.id.textView);
        textViewResult = findViewById(R.id.textViewResult);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonTimes = findViewById(R.id.buttonTimes);
        buttonClear = findViewById(R.id.buttonClear);
        buttonDelete = findViewById(R.id.buttonDelete);
        operationsRecyclerView = findViewById(R.id.operationsRecyclerView);
    }
    public void onButtonClick(View view) {
        Button button = (Button) view;
        String temp = "";
        switch (button.getText().toString()) {
            case "0" :
                if (ans) {
                    temp = textView.getText() + "0";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("0");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "1" :
                if (ans) {
                    temp = textView.getText() + "1";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("1");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "2" :
                if (ans) {
                    temp = textView.getText() + "2";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("2");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "3" :
                if (ans) {
                    temp = textView.getText() + "3";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("3");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "4" :
                if (ans) {
                    temp = textView.getText() + "4";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("4");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "5" :
                if (ans) {
                    temp = textView.getText() + "5";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("5");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "6" :
                if (ans) {
                    temp = textView.getText() + "6";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("6");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "7" :
                if (ans) {
                    temp = textView.getText() + "7";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("7");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "8" :
                if (ans) {
                    temp = textView.getText() + "8";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("8");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "9" :
                if (ans) {
                    temp = textView.getText() + "9";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("9");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "." :
                if (ans) {
                    temp = textView.getText() + ".";
                    textView.setText(temp);
                } else {
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setText("0.");
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                }
                break;
            case "=" :
                JEP jep = new JEP();
                String expression = textView.getText().toString();
                expression = expression.replace("×","*");
                expression = expression.replace("÷","/");
                if (lastCharIsOperator(expression)) {
                    expression = expression.substring(0,expression.length()-1);
                }
                jep.parseExpression(expression);
                if (jep.hasError()) {
                    System.out.println("Error: " + jep.getErrorInfo());
                    Toast.makeText(getApplicationContext(), "Error: " + jep.getErrorInfo(), Toast.LENGTH_SHORT).show();
                } else {
                    double result = jep.getValue();
                    if (Double.isInfinite(result)) {
                        textViewResult.setText("= Can't divide by zero");
                    } else if (Math.floor(result) == result) {
                        int intValue = (int) Math.floor(result);
                        textViewResult.setText("= " + intValue);
                    }
                     else {
                        textViewResult.setText("= " + result);
                    }
                }
                ans = false;
                textView.setTextSize(30);
                textViewResult.setTextSize(50);
                break;
            case "+" :
                temp = textView.getText().toString();
                if (!textViewResult.getText().toString().isEmpty() && !ans) {
                    temp = textViewResult.getText().toString();
                    temp += "+";
                    temp = temp.substring(1);
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                } else if (!lastCharIsOperator(textView.getText().toString())){
                    temp = textView.getText() + "+";
                }
                textView.setText(temp);
                break;
            case "-" :
                temp = textView.getText().toString();
                if (!textViewResult.getText().toString().isEmpty() && !ans) {
                    temp = textViewResult.getText().toString();
                    temp += "-";
                    temp = temp.substring(1);
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                } else if (!lastCharIsOperator(textView.getText().toString())) {
                    temp = textView.getText() + "-";
                }
                textView.setText(temp);
                break;
            case "×" :
                temp = textView.getText().toString();
                if (!textViewResult.getText().toString().isEmpty() && !ans) {
                    temp = textViewResult.getText().toString();
                    temp += "×";
                    temp = temp.substring(1);
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                } else if (!lastCharIsOperator(textView.getText().toString())) {
                    temp = textView.getText() + "×";
                }
                textView.setText(temp);
                break;
            case "÷" :
                temp = textView.getText().toString();
                if (!textViewResult.getText().toString().isEmpty() && !ans) {
                    temp = textViewResult.getText().toString();
                    temp += "÷";
                    temp = temp.substring(1);
                    operations.add(new Operation(textView.getText(), textViewResult.getText()));
                    operationsRecyclerView.getAdapter().notifyDataSetChanged();
                    textView.setTextSize(45);
                    textViewResult.setTextSize(30);
                    ans = true;
                } else if (!lastCharIsOperator(textView.getText().toString())) {
                    temp = textView.getText() + "÷";
                }
                textView.setText(temp);
                break;
            case "DEL" :
                if (!textView.getText().toString().isEmpty()) {
                    temp = textView.getText().toString().substring(0,textView.getText().toString().length() - 1);
                    textView.setText(temp);
                }
                break;
            case "AC" :
                operations.clear();
                operationsRecyclerView.getAdapter().notifyDataSetChanged();
                textView.setTextSize(45);
                textViewResult.setTextSize(30);
                break;
            case "C" :
                textView.setText("");
                textViewResult.setText("");
                buttonClear.setText("AC");
                textView.setTextSize(45);
                textViewResult.setTextSize(30);
                ans = true;
                break;
        }
    }
    public boolean lastCharIsOperator(String s) {
        if (s.isEmpty()) {
            return false;
        } else {
            if (textView.getText().charAt(textView.getText().length()-1) != '+'
                    && textView.getText().charAt(textView.getText().length()-1) != '-'
                    && textView.getText().charAt(textView.getText().length()-1) != '×'
                    && textView.getText().charAt(textView.getText().length()-1) != '÷') {
                return false;
            } else return true;
        }
    }
}