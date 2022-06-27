package com.example.karori;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

public class SubActivity extends AppCompatActivity {

//    String hei,wei,old,ran;
//    public SubActivity(String hei2,String wei2,String old2,String ran2){
//        this.hei = hei2;
//        this.wei = wei2;
//        this.old = old2;
//        this.ran = ran2;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button meta = findViewById(R.id.meta);
        Button bmi = findViewById(R.id.bmi);
        Button karo = findViewById(R.id.karo);
        Button end = findViewById(R.id.end);
        Listener listener = new Listener();
        meta.setOnClickListener(listener);
        bmi.setOnClickListener(listener);
        karo.setOnClickListener(listener);
        end.setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            // テキストを設定して表示
            Intent intent = getIntent();
            String hei1 = intent.getStringExtra("height");//heightってキーの要素を獲得している
            double hei = Double.parseDouble(hei1);//Str型をDouble型に変換している
            String wei1 = intent.getStringExtra("weight");
            double wei = Double.parseDouble(wei1);
            String old1 = intent.getStringExtra("old");
            int old = Integer.parseInt(old1);
            String ran1 = intent.getStringExtra("ran");
            int ran = Integer.parseInt(ran1);
            TextView view = findViewById(R.id.tex);
            TextView v2 = findViewById(R.id.tex2);
            switch (v.getId()) {//なんのボタンを押したか判別している
                case R.id.meta:
                    Toast.makeText(SubActivity.this,"基礎代謝を計算しました", Toast.LENGTH_SHORT).show();
                    double sum1 = 13.397 * wei + 4.799 * hei - 5.677 * old + 88.362;
                    view.setText("あなたの基礎代謝は" + (int) sum1 + "kcalです。");
                    break;

                case R.id.bmi:
                    Toast.makeText(SubActivity.this,"BMIを計算しました", Toast.LENGTH_SHORT).show();
                    double bmi = hei * hei/10000;
                    double Bmi = wei / bmi;

                    if (Bmi>30.0) {
                        String o = String.format("%.1f", Bmi);//少数点第一までの切り上げにする
                        String s = ("あなたのBMIは"+o+"なので");
                        view.setText(s+"めちゃくちゃムキムキです");
                    } else if (Bmi>25.0) {
                        String o = String.format("%.1f", Bmi);
                        String s = ("あなたのBMIは"+o+"なので");
                        view.setText(s+"ムキムキです");
                    } else if (Bmi>20.0) {
                        String o = String.format("%.1f", Bmi);
                        String s = ("あなたのBMIは"+o+"なので");
                        view.setText(s+"少しムキムキです");
                    } else if (Bmi>18.5) {
                        String o = String.format("%.1f", Bmi);
                        String s = ("あなたのBMIは"+o+"なので");
                        view.setText(s+"普通です");
                    } else {
                        String o = String.format("%.1f", Bmi);
                        String s = ("あなたのBMIは"+o+"なので");
                        view.setText(s+"ひょろガリです");
                    }
                   double OKwei = hei * hei/10000 * 22;
                    String good = String.format("%.1f", OKwei);
                    v2.setText("適正体重は" + good + "です");
                    break;

                case R.id.karo:
                    Toast.makeText(SubActivity.this,"あなたの推奨カロリーを計算しました", Toast.LENGTH_SHORT).show();
                    double sum2 = 13.397 * wei + 4.799 * hei - 5.677 * old + 88.362;
                    double sum = 0.0;
                    switch (ran) {
                        case 1:
                            sum = 1.2 * sum2;
                            break;
                        case 2:
                            sum = 1.375 * sum2;
                            break;
                        case 3:
                            sum = 1.55 * sum2;
                            break;
                        case 4:
                            sum = 1.725 * sum2;
                            break;
                        case 5:
                            sum = 1.9 * sum2;
                            break;
                    }
                        view.setText("あなたの一日の消費カロリーは" + (int) sum + "kcalです。");
                    break;
                case R.id.end:
                    Dia dialogFragment = new Dia();//ダイアログのクラスをインスタンス化する
                    dialogFragment.show(getSupportFragmentManager(), "");//
                    break;
            }
        }
    }
}