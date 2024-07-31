package com.example.androidcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String nowOutCome = String.valueOf(0);//最终结果显示
    private String guoCheng = "";//过程显示
    private String nowNumber = "";//当前显示
    private String b = "";//过程显示


    private float[] arri = new float[2];
    private List<String> arr = new ArrayList<>();

    private float pointTemp = 0;//记录当前数中的.数量
    private int kuoHaoTemp = 0;//记录当前数中的括号数量


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
        //设置监听器
        findViewById(R.id.zuoKuoHao).setOnClickListener(this);
        findViewById(R.id.youKuoHao).setOnClickListener(this);
        findViewById(R.id.genHao).setOnClickListener(this);
        findViewById(R.id.x2).setOnClickListener(this);
        findViewById(R.id.AC).setOnClickListener(this);
        findViewById(R.id.shanChu).setOnClickListener(this);
        findViewById(R.id.zhengFu).setOnClickListener(this);
        findViewById(R.id.divideButton).setOnClickListener(this);
        findViewById(R.id.multiplyButton).setOnClickListener(this);
        findViewById(R.id.subtractButton).setOnClickListener(this);
        findViewById(R.id.addButton).setOnClickListener(this);
        findViewById(R.id.percentage).setOnClickListener(this);
        findViewById(R.id.decimalPoint).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.amount).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.shanChu) {
            if (!nowNumber.equals("")){
                if (guoCheng.equals("")){
                    if (nowNumber.length() > 1){
                        if (nowNumber.substring(nowNumber.length() - 2).equals("√(")){
                            if (nowNumber.length() - 2 == 0){
                                nowNumber = "";
                            }else nowNumber = nowNumber.substring(0,nowNumber.length() - 2);
                            kuoHaoTemp--;
                        }else {
                            if (nowNumber.charAt(nowNumber.length() - 1) == '.'){
                                pointTemp = 0;
                            }
                            if (nowNumber.charAt(nowNumber.length() - 1) == '('){
                                kuoHaoTemp--;
                            }
                            if (nowNumber.charAt(nowNumber.length() - 1) == ')'){
                                kuoHaoTemp++;
                            }
                            if (nowNumber.length() == 1){
                                nowNumber = "";
                            }else nowNumber = nowNumber.substring(0,nowNumber.length() - 1);
                        }
                    }else {
                        if (nowNumber.charAt(nowNumber.length() - 1) == '.'){
                            pointTemp = 0;
                        }
                        if (nowNumber.charAt(nowNumber.length() - 1) == '('){
                            kuoHaoTemp--;
                        }
                        if (nowNumber.charAt(nowNumber.length() - 1) == ')'){
                            kuoHaoTemp++;
                        }
                        if (nowNumber.length() == 1){
                            nowNumber = "";
                        }else nowNumber = nowNumber.substring(0,nowNumber.length() - 1);
                    }

                }else {
                    if (nowNumber.length() > 1){
                        if (nowNumber.substring(nowNumber.length() - 2).equals("√(")){
                            if (nowNumber.length() - 2 == 0){
                                nowNumber = "";
                            }else nowNumber = nowNumber.substring(0,nowNumber.length() - 2);
                            kuoHaoTemp--;
                        }else {
                            if (nowNumber.charAt(nowNumber.length() - 1) == '.'){
                                pointTemp = 0;
                            }
                            if (nowNumber.charAt(nowNumber.length() - 1) == '('){
                                kuoHaoTemp--;
                            }
                            if (nowNumber.charAt(nowNumber.length() - 1) == ')'){
                                kuoHaoTemp++;
                            }
                            if (nowNumber.length() == 1){
                                nowNumber = "";
                            }else nowNumber = nowNumber.substring(0,nowNumber.length() - 1);
                        }
                    }else {
                        if (nowNumber.charAt(nowNumber.length() - 1) == '.'){
                            pointTemp = 0;
                        }
                        if (nowNumber.charAt(nowNumber.length() - 1) == '('){
                            kuoHaoTemp--;
                        }
                        if (nowNumber.charAt(nowNumber.length() - 1) == ')'){
                            kuoHaoTemp++;
                        }
                        if (nowNumber.length() == 1){
                            nowNumber = "";
                        }else nowNumber = nowNumber.substring(0,nowNumber.length() - 1);
                    }
                    if (nowNumber.equals("")){
                        arr.remove(arr.size() - 1);
                        if (arr.size() > 0){
                            nowNumber = arr.get(arr.size() - 1);
                            for (int i = 0; i < nowNumber.length(); i++) {
                                if (nowNumber.charAt(i) == '.'){
                                    pointTemp = 1;
                                }
                            }
                            if (guoCheng.length() - nowNumber.length() == 0){
                                guoCheng = "";
                            }else guoCheng = guoCheng.substring(0,guoCheng.length() - nowNumber.length());
                        }else guoCheng = "";
                    }
                }
            }
        }
        if (view.getId() == R.id.AC) {
            guoCheng = "";
            nowNumber = "";
            nowOutCome = "";
            arr.clear();
            kuoHaoTemp = 0;
            pointTemp = 0;
        }
//如果错误必须删
        if (nowOutCome.equals("错误")) {
            return;
        }

//加减乘除
        if (view.getId() == R.id.addButton) {
            if ((guoCheng.equals("") && nowNumber.equals("")) || (!nowNumber.equals("") && nowNumber.charAt(nowNumber.length() - 1) == '(')){
                nowNumber += "+";
            }else if (nowNumber.charAt(nowNumber.length() - 1) == '+' || nowNumber.charAt(nowNumber.length() - 1) == '-' || nowNumber.charAt(nowNumber.length() - 1) == '×'|| nowNumber.charAt(nowNumber.length() - 1) == '÷'){
                nowNumber = "+";
            }else {
                guoCheng += nowNumber;
                arr.add(nowNumber);
                nowNumber = "+";
                pointTemp = 0;
            }
        }
        //除
        if (view.getId() == R.id.divideButton) {
            if (!guoCheng.equals("") || (guoCheng.equals("") && !nowNumber.equals("") && nowNumber.charAt(nowNumber.length() - 1) != '+') && nowNumber.charAt(nowNumber.length() - 1) != '-') {
                if (nowNumber.charAt(nowNumber.length() - 1) == '+' || nowNumber.charAt(nowNumber.length() - 1) == '-' || nowNumber.charAt(nowNumber.length() - 1) == '×' || nowNumber.charAt(nowNumber.length() - 1) == '÷') {
                    nowNumber = "÷";
                } else {
                    guoCheng += nowNumber;
                    arr.add(nowNumber);
                    nowNumber = "÷";
                    pointTemp = 0;
                }
            }
        }
        //乘
        if (view.getId() == R.id.multiplyButton) {
            if (!guoCheng.equals("") || (guoCheng.equals("") && !nowNumber.equals("") && nowNumber.charAt(nowNumber.length() - 1) != '+') && nowNumber.charAt(nowNumber.length() - 1) != '-') {
                if (nowNumber.charAt(nowNumber.length() - 1) == '+' || nowNumber.charAt(nowNumber.length() - 1) == '-' || nowNumber.charAt(nowNumber.length() - 1) == '×' || nowNumber.charAt(nowNumber.length() - 1) == '÷') {
                    nowNumber = "×";
                } else {
                    guoCheng += nowNumber;
                    arr.add(nowNumber);
                    nowNumber = "×";
                    pointTemp = 0;
                }
            }

        }
        //减
        if (view.getId() == R.id.subtractButton) {
            if ((guoCheng.equals("") && nowNumber.equals("")) || (!nowNumber.equals("") && nowNumber.charAt(nowNumber.length() - 1) == '(')){
                nowNumber += "-";
            }else if (nowNumber.charAt(nowNumber.length() - 1) == '+' || nowNumber.charAt(nowNumber.length() - 1) == '-' || nowNumber.charAt(nowNumber.length() - 1) == '×'|| nowNumber.charAt(nowNumber.length() - 1) == '÷'){
                nowNumber.substring(0,nowNumber.length() - 1);
                nowNumber = "-";
            }else {
                guoCheng += nowNumber;
                arr.add(nowNumber);
                nowNumber = "-";
                pointTemp = 0;
            }

        }

//其他运算
        if (view.getId() == R.id.zhengFu) {
            if (!nowNumber.equals("")){
                if (nowNumber.charAt(0) == '+'){
                    nowNumber = "-" + nowNumber.substring(1);
                } else if (nowNumber.charAt(0) == '-'){
                    nowNumber = "+" + nowNumber.substring(1);
                } else if (nowNumber.charAt(0) != '(') {
                    nowNumber = "(-" + nowNumber + ")";
                } else if (nowNumber.charAt(1) == '-' && nowNumber.charAt(nowNumber.length() - 1) == ')') {
                    nowNumber = nowNumber.substring(2,nowNumber.length() - 1);
                }else nowNumber = "(-" + nowNumber + ")";
            }
        }
        //括号
        if (view.getId() == R.id.zuoKuoHao) {
            if (nowNumber.equals("")){
                nowNumber += "(";
                kuoHaoTemp++;
            } else if (nowNumber.charAt(nowNumber.length() - 1) == '(' || nowNumber.charAt(nowNumber.length() - 1) == '+' || nowNumber.charAt(nowNumber.length() - 1) == '-' || nowNumber.charAt(nowNumber.length() - 1) == '×' || nowNumber.charAt(nowNumber.length() - 1) == '÷') {
                nowNumber += "(";
                kuoHaoTemp++;
            }

        }
        if (view.getId() == R.id.youKuoHao) {
            if (kuoHaoTemp > 0) {
                nowNumber += ")";
                kuoHaoTemp--;
            }
        }
        if (view.getId() == R.id.decimalPoint) {
            if (pointTemp == 0 && nowNumber.length() > 0 && (nowNumber.charAt(nowNumber.length() - 1) == '0' || nowNumber.charAt(nowNumber.length() - 1) == '1' || nowNumber.charAt(nowNumber.length() - 1) == '2' || nowNumber.charAt(nowNumber.length() - 1) == '3' || nowNumber.charAt(nowNumber.length() - 1) == '4' || nowNumber.charAt(nowNumber.length() - 1) == '5' || nowNumber.charAt(nowNumber.length() - 1) == '6' || nowNumber.charAt(nowNumber.length() - 1) == '7' || nowNumber.charAt(nowNumber.length() - 1) == '8' || nowNumber.charAt(nowNumber.length() - 1) == '9')) {
                    nowNumber += ".";
                    pointTemp = 1;
            }else if (nowNumber.equals("") || nowNumber.charAt(nowNumber.length() - 1) == '('){
                nowNumber += "0.";
                pointTemp = 1;
            }
        }
        if (view.getId() == R.id.genHao) {
            if (nowNumber.equals("") || nowNumber.equals("+") || nowNumber.equals("-") || nowNumber.equals("×") || nowNumber.equals("÷")){
                nowNumber += "√(";
                kuoHaoTemp++;
            }else if (nowNumber.charAt(nowNumber.length() - 1) == '('){
                nowNumber += "√(";
                kuoHaoTemp++;
            }
        }
        if (view.getId() == R.id.x2) {
            if ((guoCheng.equals("") && !nowNumber.equals("") && nowNumber.charAt(nowNumber.length() - 1) != '+' && nowNumber.charAt(nowNumber.length() - 1) != '-' && nowNumber.charAt(nowNumber.length() - 1) != '×' && nowNumber.charAt(nowNumber.length() - 1) != '÷') || nowNumber.length() > 1 && nowNumber.charAt(nowNumber.length() - 1) != '('){
                if (nowNumber.charAt(nowNumber.length() - 1) != '²'){
                    nowNumber += "²";
                }
            }
        }
        if (view.getId() == R.id.percentage) {
            if ((guoCheng.equals("") && !nowNumber.equals("") && nowNumber.charAt(nowNumber.length() - 1) != '+' && nowNumber.charAt(nowNumber.length() - 1) != '-' && nowNumber.charAt(nowNumber.length() - 1) != '×' && nowNumber.charAt(nowNumber.length() - 1) != '÷') || nowNumber.length() > 1 && nowNumber.charAt(nowNumber.length() - 1) != '('){
                if (nowNumber.charAt(nowNumber.length() - 1) != '%'){
                    nowNumber += "%";
                }
            }
        }
        if (view.getId() == R.id.amount) {
            guoCheng = "";
            nowNumber = nowOutCome;
            arr.clear();
            kuoHaoTemp = 0;
            pointTemp = 0;
            for (int i = 0; i < nowOutCome.length(); i++) {
                if (nowOutCome.charAt(i) == '.'){
                    pointTemp = 1;
                }
            }
            nowOutCome = "";
        }
        //数字按键
        if (view.getId() == R.id.one) {
            nowNumber += "1";
        }
        if (view.getId() == R.id.two) {
            nowNumber += "2";
        }
        if (view.getId() == R.id.three) {
            nowNumber += "3";
        }
        if (view.getId() == R.id.four) {
            nowNumber += "4";
        }
        if (view.getId() == R.id.five) {
            nowNumber += "5";
        }
        if (view.getId() == R.id.six) {
            nowNumber += "6";
        }
        if (view.getId() == R.id.seven) {
            nowNumber += "7";
        }
        if (view.getId() == R.id.eight) {
            nowNumber += "8";
        }
        if (view.getId() == R.id.nine) {
            nowNumber += "9";
        }
        if (view.getId() == R.id.zero) {
            if (!nowNumber.equals("")) {
                if (nowNumber.charAt(0) != '(') {
                    nowNumber += "0";
                }
            }
        }

        //数组存数字
        if (arr.size() == 0){
            arr.add("");
        }
        arr.set(arr.size() - 1,nowNumber);




        //过程结果更新
        b = guoCheng + nowNumber;
        String a = "(" + b + ")";
        arri = kuohaoChuli(a, 0);


        //最终结果显示更新
        nowOutCome = String.valueOf(arri[0]);
        //报错
        if (!b.equals("")) {
            if (kuoHaoTemp < 0) {
                nowOutCome = "错误";
            }
            if (b.charAt(0) == '×' || b.charAt(0) == '÷' || b.charAt(0) == '%' || b.charAt(0) == '²') {
                nowOutCome = "错误";
            }
            if (b.length() > 1) {
                if (b.charAt(b.length() - 2) == ')' && (b.charAt(b.length() - 1) != '+' && b.charAt(b.length() - 1) != '-' && b.charAt(b.length() - 1) != '×' && b.charAt(b.length() - 1) != '÷' && b.charAt(b.length() - 1) != '%')) {
                    nowOutCome = "错误";
                }
            }
        }
        updateView();
    }

//
    public void updateView() {
        TextView guoChengtv = findViewById(R.id.guoCheng);
        TextView jieGuo = findViewById(R.id.jieGuo);
        guoChengtv.setText(b);
        jieGuo.setText(nowOutCome);
    }

    public static float[] kuohaoChuli(String guoCheng,int t){
        float[] arri = new float[2];
        float nowNumber2 = 1;
        float nowNumber = 0;
        float nowOutCome = 0;
        int temp1 = 0;
        int temp = 0;
        int temp2 = 0;
        int tempGou = 0;
        int tempChu = 0;
        String o = "";
        String p = "";
        if (guoCheng.length() >=3) {
            if (guoCheng.substring(guoCheng.length() - 3, guoCheng.length() - 1).equals("√(")) {
                guoCheng = guoCheng.substring(0, guoCheng.length() - 3) + ")";
                if (guoCheng.equals("()")) {
                    arri[0] = 0;
                    return arri;
                }
            }
        }
        if (guoCheng.length() >= 4) {
            if (guoCheng.substring(guoCheng.length() - 4, guoCheng.length() - 1).equals("√(+") || guoCheng.substring(guoCheng.length() - 4, guoCheng.length() - 1).equals("√(-")) {
                guoCheng = guoCheng.substring(0, guoCheng.length() - 4) + ")";
                if (guoCheng.equals("()")) {
                    arri[0] = 0;
                    return arri;
                }
            }
        }
        if (guoCheng.length() == 3){
            if(guoCheng.charAt(1) == '+' || guoCheng.charAt(1) == '-'){
                arri[0] = 0;
                return arri;
            }
        }

        for (int i = 0; i < guoCheng.length(); i++) {
            if (guoCheng.charAt(i) == '√'){
                tempGou = 1;
                continue;
            }
            if (i != 0 && guoCheng.charAt(i) == '+') {
                if (temp2 == 1){
                    o = "";
                    p = "+";
                    temp1 = i + 1;
                    temp2 = 0;
                    tempGou = 0;
                    tempChu = 0;

                    continue;
                }

                if (temp == 0) {
                    if (p.equals("+") || p.equals("")) {
                        nowOutCome += Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    if (p.equals("-")){
                        nowOutCome -= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                } else {
                    if (o.equals("×")){
                        nowNumber2 *= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    nowOutCome += nowNumber2;
                    temp = 0;
                }
                o = "+";
                p = "+";
                temp1 = i + 1;
            }
            if (i != 0 && guoCheng.charAt(i) == '-') {
                if (temp2 == 1){
                    o = "";
                    p = "-";
                    temp1 = i + 1;
                    temp2 = 0;
                    tempGou = 0;
                    tempChu = 0;
                    continue;
                }
                if (temp == 0) {
                    if (p.equals("+") || p.equals("")) {
                        nowOutCome += Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    if (p.equals("-")){
                        nowOutCome -= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                } else {
                    if (o.equals("×")){
                        nowNumber2 *= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    nowOutCome -= nowNumber2;
                    temp = 0;
                }
                o = "-";
                p = "-";
                temp1 = i + 1;


            }
            if (i != 0 && guoCheng.charAt(i) == '×'){
                if (temp2 == 1){
                    o = "×";
                    temp1 = i + 1;
                    temp2 = 0;
                    temp = 1;
                    tempGou = 0;
                    tempChu = 0;
                    continue;
                }
                if (temp == 0){
                    nowNumber2 = Float.valueOf(guoCheng.substring(temp1,i));
                    temp = 1;
                }else {
                    if (o.equals("×")){
                        nowNumber2 *= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                }
                o = "×";
                temp1 = i + 1;

            }
            if (i != 0 && guoCheng.charAt(i) == '÷'){
                if (temp2 == 1){
                    o = "÷";
                    temp1 = i + 1;
                    temp2 = 0;
                    temp = 1;
                    tempGou = 0;
                    tempChu = 0;
                    continue;
                }
                if (temp == 0){
                    nowNumber2 = Float.valueOf(guoCheng.substring(temp1,i));
                    temp = 1;
                }else {
                    if (o.equals("×")){
                        nowNumber2 *= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= Float.valueOf(guoCheng.substring(temp1, i));
                    }
                }
                o = "÷";
                temp1 = i + 1;

            }
            if (i != 0 && guoCheng.charAt(i) == '%'){
                if (temp2 == 1){
                    o = "%";
                    temp1 = i + 1;
                    temp2 = 0;
                    tempChu = 1;
                    continue;
                }
                if (tempChu == 1) {
                    if (i == guoCheng.length() - 2 || guoCheng.substring(temp1, i).equals("")) {
                        nowOutCome /= 100;
                        arri[0] = nowOutCome;
                        temp1 = i + 1;
                        temp2 = 1;
                        continue;
                    }
                }
                if (temp == 0){
                    nowNumber2 = Float.valueOf(guoCheng.substring(temp1,i)) / 100;
                    temp = 1;
                }else {
                    if (o.equals("×")){
                        nowNumber2 *= Float.valueOf(guoCheng.substring(temp1, i)) / 100;
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= Float.valueOf(guoCheng.substring(temp1, i)) / 100;
                    }
                    if (o.equals("²")){
                        nowNumber2 /= 100;
                    }
                }
                o = "%";
                temp1 = i + 1;
            }
            if (i != 0 && guoCheng.charAt(i) == '²'){
                if (temp2 == 1){
                    o = "²";
                    temp1 = i + 1;
                    temp2 = 0;
                    tempChu = 1;
                    continue;
                }
                if (tempChu == 1) {
                    if (i == guoCheng.length() - 2 || guoCheng.substring(temp1, i).equals("")) {
                        nowOutCome *= nowNumber;
                        arri[0] = nowOutCome;
                        temp1 = i + 1;
                        temp2 = 1;
                        continue;
                    }
                }
                if (temp == 0){
                    nowNumber2 = (float) Math.pow(Float.valueOf(guoCheng.substring(temp1,i)),2);
                    temp = 1;
                }else {
                    if (o.equals("×")){
                        nowNumber2 *= (float) Math.pow(Float.valueOf(guoCheng.substring(temp1,i)),2);
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= (float) Math.pow(Float.valueOf(guoCheng.substring(temp1,i)),2);
                    }
                    if (o.equals("%")){
                        nowNumber2 *= nowNumber2;
                    }
                }
                o = "²";
                temp1 = i + 1;
            }

            if (guoCheng.charAt(i) == '('){
                arri = kuohaoChuli(guoCheng.substring(i + 1),tempGou);
                temp2 = 1;
                i += arri[1];
                if (i == guoCheng.length() - 3) {
                    if (guoCheng.charAt(i + 1) == '%') {
                        arri[0] = arri[0] / 100;
                    }
                    if (guoCheng.charAt(i + 1) == '²') {
                        arri[0] *= arri[0];
                    }
                }
                if (temp == 0){
                    //加减
                    if (p.equals("+") || p.equals("")){
                        nowOutCome += arri[0];
                    }
                    if (p.equals("-")){
                        nowOutCome -= arri[0];
                    }
                }else {
                    if (o.equals("×")){
                        nowNumber2 *= arri[0];
                        //kjljl
                        if (i < guoCheng.length() - 1) {
                            if (guoCheng.charAt(i + 1) == ')') {
                                if (p.equals("+") || p.equals("")){
                                    nowOutCome += nowNumber2;
                                    arri[0] = nowOutCome;
                                }
                                if (p.equals("-")){
                                    nowOutCome -= nowNumber2;
                                    arri[0] = nowOutCome;
                                }
                            }
                            if (guoCheng.charAt(i + 1) == '%'){
                                nowOutCome += nowNumber2;
                                arri[0] = nowOutCome;
                            }
                            if (guoCheng.charAt(i + 1) == '²'){
                                nowOutCome += nowNumber2;
                                arri[0] = nowOutCome;
                            }
                        }
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= arri[0];
                        if (i < guoCheng.length() - 1) {
                            if (guoCheng.charAt(i + 1) == ')') {
                                if (p.equals("+") || p.equals("")){
                                    nowOutCome += nowNumber2;
                                    arri[0] = nowOutCome;
                                }
                                if (p.equals("-")){
                                    nowOutCome -= nowNumber2;
                                    arri[0] = nowOutCome;
                                }
                                if (guoCheng.charAt(i + 1) == '%'){
                                    nowOutCome += nowNumber2;
                                    arri[0] = nowOutCome;
                                }
                                if (guoCheng.charAt(i + 1) == '²'){
                                    nowOutCome += nowNumber2;
                                    arri[0] = nowOutCome;
                                }
                            }
                        }
                    }
                }
                continue;
            }
            if (guoCheng.charAt(i) == ')'){
                if (temp2 == 1){
                    temp2 = 0;
                    arri[1] = i;
                    arri[0] = nowOutCome;
                    continue;
                }
                if (guoCheng.substring(temp1,i).equals("") || guoCheng.substring(temp1,i).equals("²") || guoCheng.substring(temp1,i).equals("%")){

                }else nowNumber = Float.valueOf(guoCheng.substring(temp1, i));



                if (temp == 0){
                    //加减

                    if (t == 1){
                        nowNumber = (float) Math.sqrt(nowNumber);
                    }

                    if (p.equals("+") || p.equals("")){
                        nowOutCome += nowNumber;
                    }
                    if (p.equals("-")){
                        nowOutCome -= nowNumber;
                    }
                    if (i < guoCheng.length() - 2) {
                        if (guoCheng.charAt(i + 1) == '%') {
                            nowOutCome /= 100;
                        }
                        if (guoCheng.charAt(i + 1) == '²') {
                            nowOutCome *= nowOutCome;
                        }
                    }
                }else {
                    if (o.equals("×")){
                        nowNumber2 *= nowNumber;

                        if (p.equals("+") || p.equals("")){
                            nowOutCome += nowNumber2;
                        }
                        if (p.equals("-")){
                            nowOutCome -= nowNumber2;
                        }
                        if (p.equals("")){
                            nowOutCome = nowNumber2;
                        }
                        if (t == 1){
                            nowOutCome = (float) Math.sqrt(nowOutCome);
                        }
                        if (i < guoCheng.length() - 2) {
                            if (guoCheng.charAt(i + 1) == '%') {
                                nowOutCome /= 100;
                            }
                            if (guoCheng.charAt(i + 1) == '²') {
                                nowOutCome =(float) Math.pow(nowOutCome,2);
                            }
                        }
                    }
                    if (o.equals("÷")){
                        nowNumber2 /= nowNumber;
                        if (p.equals("+") || p.equals("")){
                            nowOutCome += nowNumber2;
                        }
                        if (p.equals("-")){
                            nowOutCome -= nowNumber2;
                        }
                        if (p.equals("")){
                            nowOutCome = nowNumber2;
                        }
                        if (t == 1){
                            nowOutCome = (float) Math.sqrt(nowNumber2);
                        }
                        if (i < guoCheng.length() - 2) {
                            if (guoCheng.charAt(i + 1) == '%') {
                                nowOutCome /= 100;
                            }
                            if (guoCheng.charAt(i + 1) == '²') {
                                nowOutCome =(float) Math.pow(nowOutCome,2);
                            }
                        }
                    }
                    if (o.equals("")){
                        if (p.equals("+") || p.equals("")){
                            nowOutCome += nowNumber;
                            nowOutCome += nowNumber2;
                        }
                        if (p.equals("-")){
                            nowOutCome -= nowNumber;
                            nowOutCome -= nowNumber2;
                        }
                    }
                    if (o.equals("%") || o.equals("²")){
                        if (p.equals("+") || p.equals("")){
                            nowOutCome += nowNumber2;
                        }
                        if (p.equals("-")){
                            nowOutCome -= nowNumber2;
                        }
                    }
                }

                arri[0] = nowOutCome;
                arri[1] = (float) (i + 1);
                return arri;
            }
        }
        return arri;
    }
}