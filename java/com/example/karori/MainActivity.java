package com.example.karori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText1 = findViewById(R.id.hei);//エディットテキストのID取得
        EditText editText2 = findViewById(R.id.wei);
        EditText editText3 = findViewById(R.id.old);
        EditText editText4 = findViewById(R.id.run);
        SharedPreferences prefs = getSharedPreferences("filename", MODE_PRIVATE);//filenameという名前で保存された箱を受け取る
        String height = prefs.getString("message1", "");//filenameの中にあるキーの文字列を獲得する、defValueは最初のメッセージ
        String weight = prefs.getString("message2", "");
        String old = prefs.getString("message3", "");
        String run = prefs.getString("message4", "");
        editText1.setText(height);//受け取った文字列をテキストビューで再度表示することができる
        editText2.setText(weight);
        editText3.setText(old);
        editText4.setText(run);
        TextView text = findViewById(R.id.text2);
        text.setText("1・ほぼ運動しない、2・週1.2回、3・週3～5回、4・週6.7回、5.一日に２回：");
        Button bot = findViewById(R.id.start);
        Listener listener = new Listener();
        bot.setOnClickListener(listener);
        TextView tex = findViewById(R.id.text2);
        tex.setText("毎週の運動回数を入力してください\n 1・ほぼ運動しない、2・1.2回、3・3～5回\n 4・6.7回、5.一日に２回");
    }

    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    MainActivity.this, //呼び出し元の画面
                    SubActivity.class);               //呼び出したい画面
            EditText hei = findViewById(R.id.hei);
            EditText wei = findViewById(R.id.wei);
            EditText old = findViewById(R.id.old);
            EditText ra  = findViewById(R.id.run);
            String gethei = hei.getText().toString();
            //入力された値を取得
            //   double hei2 = Double.parseDouble(gethei);
            String getwei = wei.getText().toString();
            //   double wei2 = Double.parseDouble(getwei);
            String getold = old.getText().toString();
            //        int old2 = Integer.parseInt(getold);
            String getran = ra.getText().toString();
            //   int ra2 = Integer.parseInt(getra);
            SharedPreferences prefs = getSharedPreferences("filename", MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putString("message1", hei.getText().toString());
            prefsEditor.putString("message2", wei.getText().toString());
            prefsEditor.putString("message3", old.getText().toString());
            prefsEditor.putString("message4", ra.getText().toString());

            prefsEditor.commit();
            prefsEditor.apply();

            intent.putExtra("height",gethei);//アクティビティ間の値受け渡し
            intent.putExtra("weight",getwei);
            intent.putExtra("old",getold);
            intent.putExtra("ran",getran);
            startActivity(intent);
        }
     }
}
  //      public void Lowkarori() {
  //          List<String> karori = new ArrayList();
  //          karori.add("ヨーグルト/夕食後がおすすめ");
  //          karori.add("玄米/白米の代わりに");
  //          karori.add("アーモンド/一日20個くらい");
  //          karori.add("魚/缶詰とかでもいい");
  //          karori.add("ステーキ/ダイエットのご褒美");
  //          karori.add("おでん/低カロリーなものがおおい");
  //          karori.add("セロリ/食べる量に比例して痩せる食材");
  //      }
