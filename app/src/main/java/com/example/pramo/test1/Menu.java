package com.example.pramo.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    ImageButton ib_dr, ib_st, ib_mc, ib_de;
    LinearLayout l_dr, l_st, l_mc, l_de;
    String drinks="", starters="", maincourses="", desserts="", rname, order;
    Button btn;
    String fdate, ftime;
    int fguest;
    String cname, conNum;


    String dri[];
    String sta[];
    String mac[];
    String des[];

    String g_dri[] =new String[]{"Mango Lassi","Orange Juice"};
    String g_sta[] =new String[]{"Soup","Samosa","Bajji"};
    String g_mac[] =new String[]{"Jeera Rice","Roti Sabji","Naan"};
    String g_des[] =new String[]{"Vanilla Icecream","Kheer"};

    String a_dri[] =new String[]{"Mango Lassi", "Coffee", "Tea"};
    String a_sta[] =new String[]{"Soup","Bajji"};
    String a_mac[] =new String[]{"Veg Biriyani","Chicken Biriyani","Jeera Rice"};
    String a_des[] =new String[]{"Gulab Jamoon","Kheer"};

    String c_dri[] =new String[]{"Bubble Tea", "Soy Milk", "Green Tea"};
    String c_sta[] =new String[]{"Egg Drop Soup","Spring Rolls"};
    String c_mac[] =new String[]{"Black Pepper Tofu","Sesame Noodles","Honey Walnut Shrimp"};
    String c_des[] =new String[]{"Glass Jelly","Cocunut Bar", "Custard Tart"};

    String m_dri[] =new String[]{"Strawberry Water", "Cucumber Limeade"};
    String m_sta[] =new String[]{"Soup","Nachos"};
    String m_mac[] =new String[]{"Vegie Burrito","Chicken Burrito","Taco"};
    String m_des[] =new String[]{"Chocolate Pecan Pie","Brownie"};

    String gok="Gokul Indian Restaurant";
    String anis="Anis Hyderabad House";
    String chex="Chinese Express";
    String mex="Mission Taco Joint";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle b = getIntent().getExtras();

        if(b!=null)
        {
            rname= b.getString("rname");
            fdate=b.getString("date");
            ftime=b.getString("time");
            fguest=b.getInt("guests");
            cname=b.getString("cname");
            conNum=b.getString("cnum");

        }

        if (rname.equals(gok))
        {
            dri=g_dri;
            sta=g_sta;
            mac=g_mac;
            des=g_des;
        }
        else if (rname.equals(anis))
        {
            dri=a_dri;
            sta=a_sta;
            mac=a_mac;
            des=a_des;
        }
        else if (rname.equals(chex))
        {
            dri=c_dri;
            sta=c_sta;
            mac=c_mac;
            des=c_des;
        }
        else if (rname.equals(mex))
        {
            dri=m_dri;
            sta=m_sta;
            mac=m_mac;
            des=m_des;
        }


        ib_dr=(ImageButton)findViewById(R.id.ib_drinks);
        ib_st=(ImageButton)findViewById(R.id.ib_starters);
        ib_mc=(ImageButton)findViewById(R.id.ib_mainc);
        ib_de=(ImageButton)findViewById(R.id.ib_dessert);

        l_dr=(LinearLayout)findViewById(R.id.ll_drinks);
        l_st=(LinearLayout)findViewById(R.id.ll_starters);
        l_mc=(LinearLayout)findViewById(R.id.ll_mainc);
        l_de=(LinearLayout)findViewById(R.id.ll_dessert);

        l_dr.setVisibility(View.GONE);
        l_st.setVisibility(View.GONE);
        l_mc.setVisibility(View.GONE);
        l_de.setVisibility(View.GONE);

        ib_dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drink();
                l_dr.setVisibility(l_dr.isShown()
                        ?View.GONE
                        :View.VISIBLE);
            }
        });

        ib_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                starter();
                l_st.setVisibility(l_st.isShown()
                        ?View.GONE
                        :View.VISIBLE);
            }
        });

        ib_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maincourse();
                l_mc.setVisibility(l_mc.isShown()
                        ?View.GONE
                        :View.VISIBLE);
            }
        });

        ib_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dessert();
                l_de.setVisibility(l_de.isShown()
                        ?View.GONE
                        :View.VISIBLE);
            }
        });

        btn=(Button)findViewById(R.id.btn_gotosumm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order="Drinks:\n"+drinks+"\nStarters:\n"+starters+"\nMain Course:\n"+maincourses+"\nDessert\n"+desserts;
                Intent in =new Intent(getApplicationContext(), Summary.class);
                Bundle b2=new Bundle();
                b2.putString("forder", order);
                b2.putString("rname",rname);
                b2.putString("date",fdate);
                b2.putString("time", ftime);
                b2.putInt("guests",fguest);
                b2.putString("cname", cname);
                b2.putString("cnum", conNum);
                in.putExtras(b2);
                startActivity(in);
            }
        });

    }

    public void drink()
    {

        ListView listview =(ListView) findViewById(R.id.lv_drinks);

        ListAdapter1 adapter=new ListAdapter1(this, dri);

        listview.setAdapter(adapter);

        //Set OnItemClickListener for the list view
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "You selected "+dri[position], Toast.LENGTH_SHORT).show();
                drinks=drinks.concat(dri[position]+"\n");

            }
        });

    }

    public void starter()
    {

        ListView listview =(ListView) findViewById(R.id.lv_starters);

        ListAdapter1 adapter=new ListAdapter1(this, sta);

        listview.setAdapter(adapter);

        //Set OnItemClickListener for the list view
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "You clicked "+sta[position], Toast.LENGTH_SHORT).show();
                starters=starters.concat(sta[position]+"\n");

            }
        });

    }

    public void maincourse()
    {

        ListView listview =(ListView) findViewById(R.id.lv_mainc);

        ListAdapter1 adapter=new ListAdapter1(this, mac);

        listview.setAdapter(adapter);

        //Set OnItemClickListener for the list view
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "You clicked "+mac[position], Toast.LENGTH_SHORT).show();
                maincourses=maincourses.concat(mac[position]+"\n");

            }
        });

    }

    public void dessert()
    {

        ListView listview =(ListView) findViewById(R.id.lv_dessert);

        ListAdapter1 adapter=new ListAdapter1(this, des);

        listview.setAdapter(adapter);

        //Set OnItemClickListener for the list view
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "You clicked "+des[position], Toast.LENGTH_SHORT).show();
                desserts=desserts.concat(des[position]+"\n");

            }
        });

    }

}
