package com.acadgild.s04A1ListViewAscDescOrder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Comparator;

public class ListViewSort extends AppCompatActivity {

    ListView monthsListView;
    ArrayAdapter<String> monthsArrayAdapter;
    String[] monthsNames = new String[]{"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

    Button ascBtn, descBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SortingList");
        setContentView(R.layout.activity_list_view_sort);

        ascBtn = (Button) findViewById(R.id.asc_btn);
        descBtn = (Button) findViewById(R.id.desc_btn);
        monthsListView = (ListView) findViewById(R.id.months_list);



        monthsArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monthsNames);
        monthsListView.setAdapter(monthsArrayAdapter);

        ascBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthsArrayAdapter.sort(new Comparator<String>() {
                    @Override
                    public int compare(String lhs, String rhs) {
                        return lhs.toString().compareTo(rhs.toString());
                    }
                });
                monthsListView.setAdapter(monthsArrayAdapter);
                monthsArrayAdapter.notifyDataSetChanged();
            }
        });
        descBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthsArrayAdapter.sort(new Comparator<String>() {
                    @Override
                    public int compare(String lhs, String rhs) {
                        return rhs.toString().compareTo(lhs.toString());
                    }
                });
                monthsListView.setAdapter(monthsArrayAdapter);
                monthsArrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
