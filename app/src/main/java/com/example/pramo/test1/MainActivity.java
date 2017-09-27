package com.example.pramo.test1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button btn;
    EditText e1, e2;
    String name,  conNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn_nxt);
        e1=(EditText)findViewById(R.id.et_n);
        e2=(EditText)findViewById(R.id.et_cn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=e1.getText().toString();
                conNum=e2.getText().toString();

                SharedPreferences sp= getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor edit= sp.edit();
                edit.putString("name", name);

                Intent in= new Intent(getApplicationContext(),RestTypes.class);
                Bundle b =new Bundle();
                b.putString("cname", name);
                b.putString("cnum", conNum);
                in.putExtras(b);
                startActivity(in);

            }
        });


    }
}
