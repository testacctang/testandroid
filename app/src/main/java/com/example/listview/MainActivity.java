package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt1, bt2;
    ListView lv;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.text_input1);
        bt1 = (Button) findViewById(R.id.button_add_data);
        bt2 = (Button) findViewById(R.id.button_sort_data);
        lv = (ListView) findViewById(R.id.lv);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        onBtnClickAdd();
    }

    public void onBtnClickAdd(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = et.getText().toString();
//                WebLink wl = new WebLink(result);

                arrayList.add(result);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"added!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onBtnClickSort(){
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                sortArrayList();
            }
        });
    }

    private void sortArrayList(){
//        Collections.sort(arrayList, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return s.compareTo(t1);
//            }
//        });

//        Collections.sort(arrayList);
        adapter.notifyDataSetChanged();
    }

}
