package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity implements View.OnClickListener{
    int answer;
    int arg1;
    int arg2;
    int counter = 0;
    int lastcounter = 0;
    int usl;
    int zapas;
    int imgcount;
    int arganswer;
    String outp;
    boolean correct = false;

    MediaPlayer correctsound;
    MediaPlayer falsesound;
    ImageView images;
    ImageView imagearg1;
    ImageView imagearg2;
    ImageView sign;
    Bitmap image;
    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;
    Button exit;
    Button newlevel;
    TextView output;
    TextView outputans;
    TextView counte;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        exit = (Button)findViewById(R.id.exit);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        newlevel = (Button)findViewById(R.id.button4);
        newlevel.setOnClickListener(this);
        images = (ImageView)findViewById(R.id.images);
        imagearg1 = (ImageView)findViewById(R.id.arg1); //первая картинка
        imagearg2 = (ImageView)findViewById(R.id.arg2);
        sign = (ImageView)findViewById(R.id.sign);// знаки
        outputans = findViewById(R.id.outputans);
        output = findViewById(R.id.output);
        counte = (TextView)findViewById(R.id.counte);
        correctsound  =MediaPlayer.create(this, R.raw.correct);
        falsesound  =MediaPlayer.create(this, R.raw.fail);
        engine();
    }
    @SuppressLint("ResourceType")
    public void engine(){
        Random random = new Random();
        arg1 = (int) (Math.random() * 9) + 1;
        arg2 = 0;
        arganswer = (int) (Math.random() * 9) + 1;
        usl = (int) (Math.random() * 5) + 1; // какое условие по счету
        outp = null; // вывод условия и ответа
        answer = 1; // понять в какой кнопке ответ
        images.setImageBitmap(image);
        correct = true;

        if (arganswer == 0){
            arganswer++;
        }
        if (arg1 == 1){
            arg1++;
        }

        if (arg1 == arganswer){
            arg1++;
        }
        if (usl == 1) {
            if (arg1 > arganswer){
                zapas = arganswer;
                arganswer = arg1;
                arg1 = zapas;
            }
            arg2 = arganswer - arg1;
            if (arg1 == 1) {
                outp = "У тебя есть " + arg1 + " яблоко, тебе дали ещё " + arg2 + " Сколько у тебя стало яблок?";
            }
            if (arg1 >= 2 && arg1 <= 4) {
                outp = "У тебя есть " + arg1 + " яблока, тебе дали ещё " + arg2 + " Сколько у тебя стало яблок?";
            }
            if (arg1 > 4) {
                outp = "У тебя есть " + arg1 + " яблок, тебе дали ещё " + arg2 + " Сколько у тебя стало яблок?";
            }
        }

        if (usl == 2) {
               if (arganswer > arg1){
                   zapas = arganswer;
                   arganswer = arg1;
                   arg1 = zapas;
                }
                arg2 = arg1 - arganswer;

            if (arg1 == 1 && arg2 == 1) {
                outp = "Друг подарил тебе " + arg1 + " карандаш, и другой попросил поделиться " + arg2 + " карандашом. Сколько у тебя осталось карандашей?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 ==1){
                outp = "Друг подарил тебе " + arg1 + " карандаша, и другой попросил поделиться " + arg2 + " карандашом. Сколько у тебя осталось карандашей?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 >= 2 && arg2 <= 4) {
                outp = "Друг подарил тебе " + arg1 + " карандаша, и другой попросил поделиться " + arg2 + " карандаша. Сколько у тебя осталось карандашей?";
            }
            if(arg1 >= 2 && arg1 <= 4 && arg2 > 4){
                outp = "Друг подарил тебе " + arg1 + " карандаша, и другой попросил поделиться " + arg2 + " карандашами. Сколько у тебя осталось карандашей?";
            }
            if (arg1 == 1 && arg2 >= 2 && arg2 <= 4) {
                outp = "Друг подарил тебе " + arg1 + " карандаш, и другой попросил поделиться " + arg2 + " карандашами. Сколько у тебя осталось карандашей?";
            }
            if (arg1 == 1 && arg2 > 4) {
                outp = "Друг подарил тебе " + arg1 + " карандаш, и другой попросил поделиться " + arg2 + " карандашами. Сколько у тебя осталось карандашей?";
            }
            if (arg1 > 4 && arg2 > 4) {
                outp = "Друг подарил тебе " + arg1 + " карандашей, и другой попросил поделиться " + arg2 + " карандашами. Сколько у тебя осталось каранадшей?";
            }
            if (arg1 > 4 && arg2 <= 4 && arg2 >=2 ) {
                outp = "Друг подарил тебе " + arg1 + " карандашей, и другой попросил поделиться " + arg2 + " карандашами. Сколько у тебя осталось каранадшей?";
            }
            if (arg1 > 4 && arg2 == 1) {
                outp = "Друг подарил тебе " + arg1 + " карандашей, и другой попросил поделиться " + arg2 + " карандашом. Сколько у тебя осталось каранадшей?";
            }
        }

        if (usl == 3) {
            if (arganswer > arg1){
                zapas = arganswer;
                arganswer = arg1;
                arg1 = zapas;

            }
            arg2 = arg1- arganswer;

            if (arg1 == 1 && arg2 == 1) {
                outp = "На небе было " + arg1 + " облако. Когда вышло солнце ушло " + arg2 + " облако. Сколько облаков осталось на небе?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 ==1){
                outp = "На небе было " + arg1 + " облака. Когда вышло солнце ушло " + arg2 + " облако. Сколько облаков осталось на небе?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 >= 2 && arg2 <= 4) {
                outp = "На небе было " + arg1 + " облака. Когда вышло солнце ушли " + arg2 + " облака. Сколько облаков осталось на небе?";
            }
            if(arg1 >= 2 && arg1 <= 4 && arg2 > 4){
                outp = "На небе было " + arg1 + " облака. Когда вышло солнце ушли " + arg2 + " облаков. Сколько облаков осталось на небе?";
            }
            if (arg1 == 1 && arg2 >= 2 && arg2 <= 4) {
                outp = "На небе было " + arg1 + " облако. Когда вышло солнце ушли " + arg2 + " облака. Сколько облаков осталось на небе?";
            }
            if (arg1 == 1 && arg2 > 4) {
                outp = "На небе было " + arg1 + " облако. Когда вышло солнце ушли " + arg2 + " облаков. Сколько облаков осталось на небе?";
            }
            if (arg1 > 4 && arg2 >= 2 && arg2 <= 4 ){
                outp = "На небе было " + arg1 + " облака. Когда вышло солнце ушли " + arg2 + " облаков. Сколько облаков осталось на небе?";
            }
            if (arg1 > 4 && arg2 > 4) {
                outp = "На небе было " + arg1 + " облаков. Когда вышло солнце ушли " + arg2 + " облаков. Сколько облаков осталось на небе?";
            }
            if (arg1 > 4 && arg2 == 1) {
                outp = "На небе было " + arg1 + " облаков. Когда вышло солнце ушло " + arg2 + " облако. Сколько облаков осталось на небе?";
            }

        }

        if (usl == 4) {
            if (arg1 > arganswer){
                zapas = arganswer;
                arganswer = arg1;
                arg1 = zapas;
            }
            arg2 = arganswer - arg1;

            if (arg1 == 1 && arg2 == 1) {
                outp = "Ты собрал " + arg1 + " цветок, но нужно еще " + arg2 + " цветок. Сколько нужно цветов всего?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 ==1){
                outp = "Ты собрал " + arg1 + " цветка, но нужно еще " + arg2 + " цветок. Сколько нужно цветов всего?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 >= 2 && arg2 <= 4) {
                outp = "Ты собрал " + arg1 + " цветка, но нужно еще " + arg2 + " цветка. Сколько нужно цветов всего?";
            }
            if(arg1 >= 2 && arg1 <= 4 && arg2 > 4){
                outp = "Ты собрал " + arg1 + " цветка, но нужно еще " + arg2 + " цветков. Сколько нужно цветов всего?";
            }
            if (arg1 == 1 && arg2 >= 2 && arg2 <= 4) {
                outp = "Ты собрал " + arg1 + " цветок, но нужно еще " + arg2 + " цветка. Сколько нужно цветов всего?";
            }
            if (arg1 == 1 && arg2 > 4) {
                outp = "Ты собрал " + arg1 + " цветок, но нужно еще " + arg2 + " цветков. Сколько нужно цветов всего?";
            }
            if (arg1 > 4 && arg2 > 4) {
                outp = "Ты собрал " + arg1 + " цветов, но нужно еще " + arg2 + " цветов. Сколько нужно цветов всего?";
            }
            if (arg1 > 4 && arg2 >= 2 && arg2 <= 4 ){
                outp = "Ты собрал " + arg1 + " цветов, но нужно еще " + arg2 + " цветка. Сколько нужно цветов всего?";
            }
            if (arg1 > 4 && arg2 == 1) {
                outp = "Ты собрал " + arg1 + " цветов, но нужно еще " + arg2 + " цветок. Сколько нужно цветов всего?";
            }
        }

        if (usl == 5) {
            if (arganswer > arg1){
                zapas = arganswer;
                arganswer = arg1;
                arg1 = zapas;
            }
            arg2 = arg1- arganswer;

            if (arg1 == 1 && arg2 == 1) {
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточка, а у тебя есть только " + arg2 + " уточка. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 ==1){
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточки, а у тебя есть только " + arg2 + " уточка. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 >= 2 && arg1 <= 4 && arg2 >= 2 && arg2 <= 4) {
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточки, а у тебя есть только " + arg2 + " уточки. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if(arg1 >= 2 && arg1 <= 4 && arg2 > 4){
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточки, а у тебя есть только " + arg2 + " уточек. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 == 1 && arg2 >= 2 && arg2 <= 4) {
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточка, а у тебя есть только " + arg2 + " уточки. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 == 1 && arg2 > 4) {
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточка, а у тебя есть только " + arg2 + " уточек. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 > 4 && arg2 > 4) {
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточек, а у тебя есть только " + arg2 + " уточек. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 > 4 && arg2 >= 2 && arg2 <= 4 ){
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточек, а у тебя есть только " + arg2 + " уточки. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
            if (arg1 > 4 && arg2 == 1) {
                outp = "Чтобы заполнить мешок нужно " + arg1 + " уточек, а у тебя есть только " + arg2 + " уточка. Сколько тебе не хватает для того, чтобы заполнить мешок ?";
            }
        }

        output.setText(outp);

        int btnrand = (int) (Math.random() * 4) + 1;

        if (usl != 2 && usl!=3 && usl!=5) {

            if (btnrand == 1) {

                btn.setText(String.valueOf(arganswer));
                  btn2.setText(String.valueOf(arganswer - 1));
                  btn3.setText(String.valueOf(arganswer + 1));
                  btn4.setText(String.valueOf(arganswer + 2));
                answer = 1;

            }
            if (btnrand == 2) {

                btn2.setText(String.valueOf(arganswer));
                btn.setText(String.valueOf(arganswer - 1));
                btn3.setText(String.valueOf(arganswer + 1));
                btn4.setText(String.valueOf(arganswer + 2));
                answer = 2;

            }
            if (btnrand == 3) {

                btn3.setText(String.valueOf(arganswer));
                btn2.setText(String.valueOf(arganswer - 1));
                btn.setText(String.valueOf(arganswer + 1));
                btn4.setText(String.valueOf(arganswer + 2));
                answer = 3;

            }
            if (btnrand == 4) {

                btn4.setText(String.valueOf(arganswer));
                btn2.setText(String.valueOf(arganswer - 1));
                btn3.setText(String.valueOf(arganswer + 1));
                btn.setText(String.valueOf(arganswer + 2));
                answer = 4;

            }
        }

        if (usl == 2 || usl == 3 || usl == 5){

            if (btnrand == 1) {

                btn.setText(String.valueOf(arganswer));
                btn2.setText(String.valueOf(arganswer - 1));
                btn3.setText(String.valueOf(arganswer + 1));
                btn4.setText(String.valueOf(arganswer + 2));

            }
            if (btnrand == 2) {

                btn2.setText(String.valueOf(arganswer));
                btn.setText(String.valueOf(arganswer - 1));
                btn3.setText(String.valueOf(arganswer + 1));
                btn4.setText(String.valueOf(arganswer + 2));
                  answer = 2;

            }
            if (btnrand == 3) {

                btn3.setText(String.valueOf(arganswer));
                btn2.setText(String.valueOf(arganswer - 1));
                btn.setText(String.valueOf(arganswer + 1));
                btn4.setText(String.valueOf(arganswer + 2));
                answer = 3;

            }
            if (btnrand == 4) {

                btn4.setText(String.valueOf(arganswer));
                answer = 4;
                btn2.setText(String.valueOf(arganswer - 1));
                btn3.setText(String.valueOf(arganswer + 1));
                btn.setText(String.valueOf(arganswer + 2));

            }
        }
        counte.setText("Ваш счёт: " + String.valueOf(counter));
        lastcounter = counter;

//        Toast toast = Toast.makeText(getApplicationContext(), arg1+ " " + arg2 + " " + arganswer , Toast.LENGTH_SHORT);
//        toast.show();

//                         ЗНАКИ
        if (usl == 1 || usl == 4 ){
            sign.setImageResource(R.drawable.plus);
        }
        if (usl == 2 || usl == 3 || usl == 5 ){
            sign.setImageResource(R.drawable.minus);
        }

//                        ЯБЛОКИ

        if (arg1 == 1 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple1);
        }
        if (arg1 == 2 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple2);
        }
        if (arg1 == 3 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple3);
        }
        if (arg1 == 4 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple4);
        }
        if (arg1 == 5 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple5);
        }
        if (arg1 == 6 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple6);
        }
        if (arg1 == 7 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple7);
        }
        if (arg1 == 8 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple8);
        }
        if (arg1 == 9 && usl == 1){
            imagearg1.setImageResource(R.drawable.apple9);
        }


        if (arg2 == 1 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple1);
        }
        if (arg2 == 2 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple2);
        }
        if (arg2 == 3 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple3);
        }
        if (arg2 == 4 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple4);
        }
        if (arg2 == 5 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple5);
        }
        if (arg2 == 6 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple6);
        }
        if (arg2 == 7 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple7);
        }
        if (arg2 == 8 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple8);
        }
        if (arg2 == 9 && usl == 1){
            imagearg2.setImageResource(R.drawable.apple9);
        }

//                      КАРАНДАШИ

        if (arg1 == 1 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil);
        }
        if (arg1 == 2 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil2);
        }
        if (arg1 == 3 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil3);
        }
        if (arg1 == 4 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil4);
        }
        if (arg1 == 5 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil5);
        }
        if (arg1 == 6 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil6);
        }
        if (arg1 == 7 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil7);
        }
        if (arg1 == 8 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil8);
        }
        if (arg1 == 9 && usl == 2){
            imagearg1.setImageResource(R.drawable.pencil9);
        }


        if (arg2 == 1 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil);
        }
        if (arg2 == 2 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil2);
        }
        if (arg2 == 3 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil3);
        }
        if (arg2 == 4 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil4);
        }
        if (arg2 == 5 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil5);
        }
        if (arg2 == 6 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil6);
        }
        if (arg2 == 7 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil7);
        }
        if (arg2 == 8 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil8);
        }
        if (arg2 == 9 && usl == 2){
            imagearg2.setImageResource(R.drawable.pencil9);
        }

//                        ОБЛАКА

        if (arg1 == 1 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud);
        }
        if (arg1 == 2 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud2);
        }
        if (arg1 == 3 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud3);
        }
        if (arg1 == 4 && usl == 3) {
            imagearg1.setImageResource(R.drawable.cloud4);
        }
        if (arg1 == 5 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud5);
        }
        if (arg1 == 6 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud6);
        }
        if (arg1 == 7 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud7);
        }
        if (arg1 == 8 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud8);
        }
        if (arg1 == 9 && usl == 3){
            imagearg1.setImageResource(R.drawable.cloud9);
        }


        if (arg2 == 1 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud);
        }
        if (arg2 == 2 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud2);
        }
        if (arg2 == 3 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud3);
        }
        if (arg2 == 4 && usl == 3) {
            imagearg2.setImageResource(R.drawable.cloud4);
        }
        if (arg2 == 5 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud5);
        }
        if (arg2 == 6 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud6);
        }
        if (arg2 == 7 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud7);
        }
        if (arg2 == 8 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud8);
        }
        if (arg2 == 9 && usl == 3){
            imagearg2.setImageResource(R.drawable.cloud9);
        }

//                    ЦВЕТЫ

        if (arg1 == 1 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower);
        }
        if (arg1 == 2 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower2);
        }
        if (arg1 == 3 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower3);
        }
        if (arg1 == 4 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower4);
        }
        if (arg1 == 5 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower5);
        }
        if (arg1 == 6 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower6);
        }
        if (arg1 == 7 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower7);
        }
        if (arg1 == 8 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower8);
        }
        if (arg1 == 9 && usl == 4){
            imagearg1.setImageResource(R.drawable.flower9);
        }


        if (arg2 == 1 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower);
        }
        if (arg2 == 2 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower);
        }
        if (arg2 == 3 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower3);
        }
        if (arg2 == 4 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower4);
        }
        if (arg2 == 5 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower5);
        }
        if (arg2 == 6 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower6);
        }
        if (arg2 == 7 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower7);
        }
        if (arg2 == 8 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower8);
        }
        if (arg2 == 9 && usl == 4){
            imagearg2.setImageResource(R.drawable.flower9);
        }

//                УТОЧКИ

        if (arg1 == 1 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck);
        }
        if (arg1 == 2 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck2);
        }
        if (arg1 == 3 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck3);
        }
        if (arg1 == 4 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck4);
        }
        if (arg1 == 5 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck5);
        }
        if (arg1 == 6 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck6);
        }
        if (arg1 == 7 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck7);
        }
        if (arg1 == 8 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck8);
        }
        if (arg1 == 9 && usl == 5){
            imagearg1.setImageResource(R.drawable.duck9);
        }


        if (arg2 == 1 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck);
        }
        if (arg2 == 2 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck2);
        }
        if (arg2 == 3 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck3);
        }
        if (arg2 == 4 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck4);
        }
        if (arg2 == 5 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck5);
        }
        if (arg2 == 6 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck6);
        }
        if (arg2 == 7 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck7);
        }
        if (arg2 == 8 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck8);
        }
        if (arg2 == 9 && usl == 5){
            imagearg2.setImageResource(R.drawable.duck9);
        }

    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view){
        outp="0";
        //newlevel.setVisibility(View.INVISIBLE);
            switch (view.getId()) {
                case R.id.button:{
                    if (answer == 1) {
                        correctsound.start();
                        counter = lastcounter + 1;
                        outputans.setText(R.string.correct);
                        newlevel.setEnabled(true);
                    } else {
                         falsesound.start();
                        outputans.setText(R.string.mistake);
                        newlevel.setEnabled(true);
                    }
                    break;}
                case R.id.button2:{
                    if (answer == 2) {
                        correctsound.start();
                        counter = lastcounter + 1;
                        outputans.setText(R.string.correct);
                        newlevel.setEnabled(true);
                    } else {
                        falsesound.start();
                        outputans.setText(R.string.mistake);
                        newlevel.setEnabled(true);
                    }
                    break;}
                case R.id.button3:{
                    if (answer == 3) {
                        correctsound.start();
                        counter = lastcounter + 1;
                        outputans.setText(R.string.correct);
                        newlevel.setEnabled(true);
                    } else {
                        falsesound.start();
                        outputans.setText(R.string.mistake);
                        newlevel.setEnabled(true);
                    }
                    break;}
                case R.id.button4:{
                    if (answer == 4) {
                        correctsound.start();
                        counter = lastcounter + 1;
                        outputans.setText(R.string.correct);
                        newlevel.setEnabled(true);
                    } else {
                        falsesound.start();
                        outputans.setText(R.string.mistake);
                        newlevel.setEnabled(true);
                    }
                    break;}
                case R.id.exit:{
                   finish();
                    break;}
            }
                switch (view.getId()) {
                    case R.id.nextlevel: {
                        engine();
                        outputans.setText(R.string.newstring);
                    }
                }
        };
    }