package jp.suntech.s21020.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;
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
        //表示ボタンであるButtonオブジェクトを取得
        Button btClick = findViewById(R.id.btIn);
        //リスナクラスのインスタンスを生成
        HelloListener listener = new HelloListener();
        //表示ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        Button btClearLive = findViewById(R.id.btLive);
        btClearLive.setOnClickListener(listener);

        Button btClearName = findViewById(R.id.btName);
        btClearName.setOnClickListener(listener);
    }

    private class HelloListener implements View.OnClickListener {
        //イベントハンドラ
        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトを取得
            EditText inputLive = findViewById(R.id.etLive);
            EditText inputName = findViewById(R.id.etName);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOut);
            int id = view.getId();
            switch (id) {
                case R.id.btIn:      //表示ボタン
                    //入力された名前文字列を取得
                    String inputStr_live = inputLive.getText().toString();
                    String inputStr_name = inputName.getText().toString();
                    //メッセージを表示
                    output.setText(inputStr_live + "にお住まいの" + inputStr_name + "さん、こんにちは！");
                    break;
                case R.id.btLive:      //クリアボタン
                    //名前入力欄に空文字を設定
                    inputLive.setText("");
                    //メッセージ入力欄に空文字を設定
                    output.setText("");
                    break;
                case R.id.btName:      //クリアボタン
                    //名前入力欄に空文字を設定
                    inputName.setText("");
                    //メッセージ入力欄に空文字を設定
                    output.setText("");
                    break;
            }
        }
    }
}