package com.cste.nstu06.suvro.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText ed_topic, ed_details;
    String [] x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listfromxml);
        ed_topic = (EditText) findViewById(R.id.topicxml);
        ed_details = (EditText) findViewById(R.id.detailsxml);


        final MyDataBaseHelper mydbh = new MyDataBaseHelper(this);
        x = mydbh.getTopics();

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, x);
        lv.setAdapter(ad);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                  //  Toast.makeText(getApplicationContext(),"long detecyed", Toast.LENGTH_LONG).show();
                MyDataBaseHelper mydbh = new MyDataBaseHelper(MainActivity.this);
                mydbh.deleteItem(x[pos]);

                ArrayAdapter ad = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, x);
                lv.setAdapter(ad);

                Toast.makeText(getApplicationContext(),"deleted", Toast.LENGTH_LONG).show();

                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Bundle tempBundle = new Bundle();
            onCreate(tempBundle);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void oYe (View v) {

        MyDataBaseHelper mydbh = new MyDataBaseHelper(this);
        mydbh.addNewCseTopic(new CSEGuide(ed_topic.getText().toString(),ed_details.getText().toString()));

        Toast.makeText(getApplicationContext(),"Added", Toast.LENGTH_LONG).show();



    }


}
