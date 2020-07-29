package com.example.kalkulator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleMode extends AppCompatActivity {
    private TextView textView;
    private double firstNumber;
    private double secondNumber;
    private String operation = "NONE";
    private boolean clickOperation;
    private StringBuilder input;

    protected void initialize(){
        textView = findViewById(R.id.textView2);
        input = new StringBuilder();
        textView.setText(input);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initialize();
        if (savedInstanceState != null) {
            firstNumber = savedInstanceState.getDouble("firstNumber");
            secondNumber = savedInstanceState.getDouble("secondNumber");
            clickOperation = savedInstanceState.getBoolean("clickOperation");
            operation = savedInstanceState.getString("operation");
            input.append(savedInstanceState.getString("input"));
            refreshInput();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble("firstNumber", firstNumber);
        outState.putDouble("secondNumber", secondNumber);
        outState.putBoolean("clickOperation", clickOperation);
        outState.putString("operation", operation);
        outState.putString("input", input.toString());
        super.onSaveInstanceState(outState);
    }


    public void multiplication(View view) {
        addNumbers("MULTIPLICATION");
    }

    public void addition(View view) {
        addNumbers("ADDITION");
    }

    public void subtraction(View view) {
        addNumbers("SUBTRACTION");
    }

    public void division(View view) {
        addNumbers("DIVISION");
    }

    void addNumbers(String operation){
        if(!clickOperation){
            if(addFirstNumber()) {
                this.operation = operation;
                clickOperation = true;
            }
        }
        else{
            if(addSecondNumber()) {
                this.firstNumber = returnResult();
            }
            this.operation = operation;
        }
    }

    public void equal(View view) {
        if(operation=="NONE"){
            addToast("No operation chosen");
        }else{
            if(addSecondNumber()) {
                showResult();
                refreshInput();
            }
        }
        operation = "NONE";
    }

    public void backspace(View view) {
        if(input.length() > 0){
            input = input.deleteCharAt(input.length() - 1);
        }
        refreshInput();
    }

    public void refreshInput(){
        textView.setText(input);
    }

    public void clear(View view) {
        operation = "NONE";
        clickOperation = false;
        firstNumber = 0;
        secondNumber = 0;
        input.setLength(0);
        refreshInput();
    }

    public double returnResult(){
        double value = 0;
        if(operation=="ADDITION"){
            value = firstNumber + secondNumber;
        }
        if(operation=="SUBTRACTION"){
            value = firstNumber - secondNumber;
        }
        if(operation=="MULTIPLICATION"){
            value = firstNumber * secondNumber;
        }
        if(operation=="DIVISION"){
            if(secondNumber != 0) {
                value = firstNumber / secondNumber;
            }
            else{
                addToast("Can't divide by 0");
            }
        }
        return value;
    }

    public void showResult(){
        double value = returnResult();
        input.setLength(0);
        input.append(value);
        firstNumber = value;
        clickOperation = false;
    }

    public void addToast(String information){
        Context context = getApplicationContext();
        CharSequence text = information;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public boolean addFirstNumber(){
        try {
            firstNumber = Double.parseDouble(input.toString());
            input.setLength(0);
            refreshInput();
            return true;
        }catch(NumberFormatException ignored){
            return false;
        }
    }

    public boolean addSecondNumber(){
        try {
            secondNumber = Double.parseDouble(input.toString());
            input.setLength(0);
            refreshInput();
            return true;
        }
        catch(NumberFormatException ignored){
            return false;
        }
    }

    public void changeSign(View view) {
        try{
            double value = Double.parseDouble(input.toString());
            if(value < 0){
                input.deleteCharAt(0);
            }
            else if(value > 0){
                input.insert(0,"-");
            }
        }
        catch(NumberFormatException ignored){
        }
        refreshInput();
    }



    public void addComa(View view) {
        if(!input.toString().contains(".")) {
            if (input.toString().equals("")) {
                input.insert(0, "0.");
            } else {
                input.insert(input.length(), ".");
            }
        }
        refreshInput();
    }

    public void Button0(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("0");
            refreshInput();
        }
    }

    public void Button1(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("1");
            refreshInput();
        }
    }

    public void Button2(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("2");
            refreshInput();
        }
    }

    public void Button3(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("3");
            refreshInput();
        }
    }

    public void Button4(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("4");
            refreshInput();
        }
    }

    public void Button5(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("5");
            refreshInput();
        }
    }

    public void Button6(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("6");
            refreshInput();
        }
    }

    public void Button7(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("7");
            refreshInput();
        }
    }

    public void Button8(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("8");
            refreshInput();
        }
    }

    public void Button9(View view) {
        if(input.toString().startsWith("0") && input.length() == 1){
            input.deleteCharAt(0);
        }
        if(input.length()>=15)
        {
            addToast("Number cannot have more than 15 digits");
        }
        else {
            input.append("9");
            refreshInput();
        }
    }
}