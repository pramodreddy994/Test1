package com.example.pramo.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Indian extends AppCompatActivity {
    String IR1="Anis Hyderabad House";
    String IR2="Gokul Indian Restaurant";


    String a1="West Park Center, 12637 Olive Blvd\nSt. Louis, MO 63141";
    String a2="6101 Delmar Blvd\nSt. Louis, MO 63112";
    // String IR3="India Palace\n4534 Long Rd\nBridgeton, MO 63044";

    String t1="MON:10AM-2PM\nTUE:10AM-2PM\nWED:10AM-2PM\nTHU:10AM-2PM\nSAT:10AM-6PM\nSUN:10AM-6PM";
    String t2="MON:Closed\nTUE:10AM-2PM\nWED:Closed\nTHU:10AM-2PM\nSAT:10AM-6PM\nSUN:10AM-6PM";

    String res[] =new String[]{IR1, IR2};
    String addr[] = new String[]{a1,a2};
    String time[] = new String[]{t1,t2};
    String name, conNum;
    //String logoname[]={"anis", "gokul", "ipalace"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian);

        Bundle b = getIntent().getExtras();

        if(b!=null)
        {
            name= b.getString("cname");
            conNum= b.getString("cnum");

        }


        ListView listview =(ListView) findViewById(R.id.lv_I);

        ListAdapter adapter=new ListAdapter(this, res);

        listview.setAdapter(adapter);

        //Set OnItemClickListener for the list view
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "You clicked "+res[position], Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), name+conNum, Toast.LENGTH_SHORT).show();

                Intent in= new Intent(getApplicationContext(), ResPage.class);
                Bundle b =new Bundle();
                b.putString("name", res[position]);
                b.putString("addr", addr[position]);
                b.putString("time", time[position]);
                b.putString("cname", name);
                b.putString("cnum", conNum);
                in.putExtras(b);
                startActivity(in);
            }
        });
    }
}
