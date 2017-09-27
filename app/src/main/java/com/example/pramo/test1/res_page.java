package com.example.pramo.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

public class res_page extends AppCompatActivity {

    NumberPicker day, mon, hrs, min, a_p, nog;
    String[] months =new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    String[] aorp= new String[]{"AM", "PM"};
    String rname, addr, tim;
    TextView na, ad, time;
    ImageButton ibtn;
    Button btn;
    String fdate, ftime;
    int fguest;
    String cname, conNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_page);


        day=(NumberPicker)findViewById(R.id.day);
        day.setMinValue(1);
        day.setMaxValue(31);

        mon=(NumberPicker)findViewById(R.id.mon);
        mon.setDisplayedValues(months);
        mon.setMinValue(0);
        mon.setMaxValue(11);

        hrs=(NumberPicker)findViewById(R.id.hrs);
        hrs.setMinValue(1);
        hrs.setMaxValue(12);

        min=(NumberPicker)findViewById(R.id.mins);
        min.setMinValue(1);
        min.setMaxValue(60);

        a_p=(NumberPicker)findViewById(R.id.a_p);
        a_p.setDisplayedValues(aorp);
        a_p.setMinValue(0);
        a_p.setMaxValue(1);

        nog=(NumberPicker)findViewById(R.id.nog);
        nog.setMinValue(1);
        nog.setMaxValue(20);

        //get name and addr

        Bundle b1 = getIntent().getExtras();

        if(b1!=null)
        {
            cname= b1.getString("cname");
            conNum= b1.getString("cnum");
            rname= b1.getString("name");
            addr=b1.getString("addr");
            tim=b1.getString("time");
        }

        na=(TextView)findViewById(R.id.tv_welcome);
        na.setText("Welcome to "+rname);

        ad=(TextView)findViewById(R.id.address);
        ad.setText(addr);

        time=(TextView)findViewById(R.id.time2);
        time.setText(tim);
        time.setVisibility(View.GONE);

        ibtn=(ImageButton)findViewById(R.id.ib);
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time.setVisibility(time.isShown()
                        ?View.GONE
                        :View.VISIBLE);
            }
        });

        btn=(Button)findViewById(R.id.btn_gotomenu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(), cname+conNum, Toast.LENGTH_SHORT).show();

                String da=String.valueOf(day.getValue());
                String mo=months[mon.getValue()];
                fdate=da+"-"+mo+"2017";

                String hr=String.valueOf(hrs.getValue());
                String mi=String.valueOf(min.getValue());
                String ap=aorp[a_p.getValue()];
                ftime=hr+":"+mi+ap;

                fguest=nog.getValue();

                Intent in= new Intent(getApplicationContext(), Menu.class);
                Bundle b =new Bundle();
                b.putString("rname",rname);
                b.putString("date",fdate);
                b.putString("time", ftime);
                b.putInt("guests",fguest);
                b.putString("cname", cname);
                b.putString("cnum", conNum);
                in.putExtras(b);


                startActivity(in);
            }
        });

    }

}
