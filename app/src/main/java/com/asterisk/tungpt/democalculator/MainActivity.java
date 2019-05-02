package com.asterisk.tungpt.democalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvInput1, tvInput2, tvFunc, tvResult;
    Button btnClear, btnPercent, btnDel, btnAdd, btnSub,
            btnMul, btnDiv, btnSeven, btnEight, btnNine,
            btnFour, btnFive, btnSix, btnOne, btnTwo,
            btnThree, btnResult, btnDot, btnZero;
    private static StringBuilder mInput1 = new StringBuilder();
    private static StringBuilder mInput2 = new StringBuilder();
    private static String mFunc = "";
    private static String mResult = "";
    private static boolean mFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
        setEvents();
    }

    private void setControls() {
        tvInput1 = findViewById(R.id.textview_input1);
        tvFunc = findViewById(R.id.textview_func);
        tvInput2 = findViewById(R.id.textview_input2);
        tvResult = findViewById(R.id.textview_result);
        btnClear = findViewById(R.id.button_clear);
        btnAdd = findViewById(R.id.button_add);
        btnClear = findViewById(R.id.button_clear);
        btnPercent = findViewById(R.id.button_percent);
        btnDel = findViewById(R.id.button_delete);
        btnSub = findViewById(R.id.button_sub);
        btnMul = findViewById(R.id.button_mul);
        btnDiv = findViewById(R.id.button_div);
        btnSeven = findViewById(R.id.button_seven);
        btnEight = findViewById(R.id.button_eight);
        btnNine = findViewById(R.id.button_nine);
        btnFour = findViewById(R.id.button_four);
        btnFive = findViewById(R.id.button_five);
        btnSix = findViewById(R.id.button_six);
        btnOne = findViewById(R.id.button_one);
        btnTwo = findViewById(R.id.button_two);
        btnThree = findViewById(R.id.button_three);
        btnResult = findViewById(R.id.button_result);
        btnDot = findViewById(R.id.button_dot);
        btnZero = findViewById(R.id.button_zero);
        setView(tvInput1, mInput1);
        setView(tvInput2, mInput2);
        setView(tvFunc, mFunc);
        setView(tvResult, mResult);
    }

    private void setEvents() {
        btnClear.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnZero.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_clear:
                clear();
                break;
            case R.id.button_percent:
                if(mResult.length() != 0) {
                    replaceInput1ByResult();
                    mInput1.append("%");
                    setView(tvInput1, mInput1);
                    mInput2 = new StringBuilder();
                    mFunc = "";
                    mResult = String.valueOf(Float.parseFloat(mResult)/100);
                    setView(tvResult, mResult);
                }
                else if(mInput2.length() != 0){
                    float ip2 = Float.parseFloat(mInput2.toString())/100;
                    mInput2 = new StringBuilder();
                    mInput2.append(ip2);
                    float ip1 = Float.parseFloat(mInput1.toString());
                    setView(tvInput2, mInput2);
                    checkResult(ip1, ip2);
                }
                else {
                    float ip1 = (Float.parseFloat(mInput1.toString())/100);
                    mInput1 = new StringBuilder();
                    mInput1.append(ip1);
                    mInput2 = new StringBuilder();
                    mFunc = "";
                    setView(tvInput1, mInput1);
                }
                break;
            case R.id.button_delete:
                if(mFunc.length() == 0 && mInput1.length() != 0) mInput1.deleteCharAt(mInput1.length()-1);
                else if(mInput2.length() != 0) mInput2.deleteCharAt(mInput2.length()-1);
                break;
            case R.id.button_mul:
                if(mResult.length() != 0) saveResult();
                if(mInput1.length() != 0) mFunc = "x";
                setView(tvFunc, mFunc);
                break;
            case R.id.button_div:
                if(mResult.length() != 0) saveResult();
                if(mInput1.length()!=0) mFunc = "/";
                setView(tvFunc, mFunc);
                break;
            case R.id.button_sub:
                if(mResult.length() != 0) saveResult();
                if(mInput1.length()!=0) mFunc = "-";
                setView(tvFunc, mFunc);
                break;
            case R.id.button_add:
                if(mResult.length() != 0) saveResult();
                if(mInput1.length()!=0) mFunc = "+";
                setView(tvFunc, mFunc);
                break;
            case R.id.button_dot:
                if(mFunc.equals("")) mInput1.append(".");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("0.");
                    mFlag = true;
                }
                else if(mInput2.length()==0) mInput2.append("0.");
                else mInput2.append(".");
                break;
            case R.id.button_zero:
                if(mFunc.equals("")) mInput1.append("0");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("0");
                    mFlag = true;
                }
                else mInput2.append("0");
                break;
            case R.id.button_one:
                if(mFunc.equals("")) mInput1.append("1");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("1");
                    mFlag = true;
                }
                else mInput2.append("1");
                break;
            case R.id.button_two:
                if(mFunc.equals("")) mInput1.append("2");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("2");
                    mFlag = true;
                }
                else mInput2.append("2");
                break;
            case R.id.button_three:
                if(mFunc.equals("")) mInput1.append("3");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("3");
                    mFlag = true;
                }
                else mInput2.append("3");
                break;
            case R.id.button_four:
                if(mFunc.equals("")) mInput1.append("4");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("4");
                    mFlag = true;
                }
                else mInput2.append("4");
                break;
            case R.id.button_five:
                if(mFunc.equals("")) mInput1.append("5");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("5");
                    mFlag = true;
                }
                else mInput2.append("5");
                break;
            case R.id.button_six:
                if(mFunc.equals("")) mInput1.append("6");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("6");
                    mFlag = true;
                }
                else mInput2.append("6");
                break;
            case R.id.button_seven:
                if(mFunc.equals("")) mInput1.append("7");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("7");
                    mFlag = true;
                }
                else mInput2.append("7");
                break;
            case R.id.button_eight:
                if(mFunc.equals("")) mInput1.append("8");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("8");
                    mFlag = true;
                }
                else mInput2.append("8");
                break;
            case R.id.button_nine:
                if(mFunc.equals("")) mInput1.append("9");
                else if(mResult.length()!=0 && !mFlag){
                    saveResult();
                    mInput2.append("9");
                    mFlag = true;
                }
                else mInput2.append("9");
                break;
            case R.id.button_result:
                if(mInput1.length() == 0 || mInput2.length() == 0) {
                    Toast.makeText(this,
                            "Vui lòng nhập phép tính",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    mFlag = false;
                    float ip1 = 0;
                    float ip2 = 0;
                    ip1 = Float.parseFloat(mInput1.toString());
                    ip2 = Float.parseFloat(mInput2.toString());
                    checkResult(ip1, ip2);
                }
                break;
        }
        setView(tvInput1, mInput1);
        setView(tvInput2, mInput2);
        setView(tvResult, mResult);
        setView(tvFunc, mFunc);
    }

    private void checkResult(float ip1, float ip2) {
        float kq = 0;
        switch (mFunc) {
            case "+":
                kq = ip1 + ip2;
                if(mResult.length() != 0){
                    showResult(kq);
                    ip1 = kq;
                    replaceInput1ByResult();
                    kq = ip1 + ip2;
                    showResult(kq);
                }
                else showResult(kq);
                break;
            case "-":
                kq = ip1 - ip2;
                if(mResult.length() != 0){
                    showResult(kq);
                    ip1 = kq;
                    replaceInput1ByResult();
                    kq = ip1 - ip2;
                    showResult(kq);
                }
                else showResult(kq);
                break;
            case "x":
                kq = ip1 * ip2;
                if(mResult.length() != 0){
                    showResult(kq);
                    ip1 = kq;
                    replaceInput1ByResult();
                    kq = ip1 * ip2;
                    showResult(kq);
                }
                else showResult(kq);
                break;
            case "/":
                if (Float.parseFloat(mInput2.toString()) == 0) {
                    clear();
                    Toast.makeText(this, "Phép chia không hợp lệ", Toast.LENGTH_SHORT).show();
                } else {
                    kq = ip1/ip2;
                    if(mResult.length() != 0){
                        showResult(kq);
                        ip1 = kq;
                        replaceInput1ByResult();
                        kq = ip1 / ip2;
                        showResult(kq);
                    }
                    else showResult(kq);
                }
                break;
        }
    }
    private void showResult(float kq) {
        if(kq%1 != 0) mResult = String.valueOf(kq);
        else mResult = String.valueOf((int)kq);
        if(kq > 2147483647)
            Toast.makeText(this, "Kết quả quá lớn, ngoài khả năng tính toán của máy ", Toast.LENGTH_SHORT).show();
    }
    private void setView(TextView view, String string){
        if(view != null) view.setText(string);
    }
    private void setView(TextView view, StringBuilder string){
        if(view!= null) view.setText(string);
    }
    private void saveResult(){
        if(mFunc.length()!=0){
            replaceInput1ByResult();
            mInput2 = new StringBuilder();
        }
    }
    private void replaceInput1ByResult() {
        mInput1 = new StringBuilder();
        mInput1.append(mResult);
    }
    private void clear(){
        mInput1 = new StringBuilder();
        mInput2 = new StringBuilder();
        mFunc = "";
        mResult = "";
    }
}
