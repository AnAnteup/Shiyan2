package com.example.administrator.shiyan2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView mText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.Textview);
        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            //给按钮注册点击事件，打开新的Acticity
            @Override
            public void onClick(View v) {
                //为Intent设置要激活的组件（将要激活TheOtherActivity这个Activity）
                Intent intent =new Intent(MainActivity.this,TheOtherActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == 3){//resultCode为4中setResult(3,intent)设置的值
            String text = data.getStringExtra("text");
            mText.setText("接受的数据为："+text);
        }
    }

}