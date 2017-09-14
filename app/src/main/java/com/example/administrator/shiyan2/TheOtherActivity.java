package com.example.administrator.shiyan2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TheOtherActivity extends Activity {
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_other);

        Button btn = (Button) findViewById(R.id.button2);
        textview = (TextView) findViewById(R.id.Textview2);

        //2、跳转到C
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TheOtherActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {//添加resultCode判断
            Intent intent = new Intent();
            String text = data.getExtras().getString("text");
            intent.putExtra("text", text);
            setResult(3, intent);
            finish();
        }
    }
}