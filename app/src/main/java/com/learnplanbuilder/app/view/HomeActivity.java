package com.learnplanbuilder.app.view;
/**
 * Created by Sunil gowroji
 */

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.learnplanbuilder.app.model.Item;
import com.learnplanbuilder.app.R;
import com.ramotion.foldingcell.FoldingCell;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ListView theListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.home_main);

        // get our list view
        theListView  = findViewById(R.id.mainListView);


        // prepare elements to display
        final ArrayList<Item> itemlist = Item.getTestingList();

        // add custom btn handler to first list item
        itemlist.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast3 = Toast.makeText(getApplicationContext(), "Feature is not available, Pay with Google pay!!", Toast.LENGTH_SHORT);
                TextView v3 = (TextView) toast3.getView().findViewById(android.R.id.message);
                toast3.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                v3.setTextColor(Color.WHITE);
                v3.setTextSize(20);
                toast3.show();
            }
        });

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this, itemlist);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast3 = Toast.makeText(getApplicationContext(), "Purchase completed successfully!!", Toast.LENGTH_SHORT);
                TextView v3 = (TextView) toast3.getView().findViewById(android.R.id.message);
                toast3.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                v3.setTextColor(Color.WHITE);
                v3.setTextSize(20);
                toast3.show();
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
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
        int id = item.getItemId();

        switch (id){
            case R.id.add:
                Toast toast = Toast.makeText(getApplicationContext(),"Please add your family members",Toast.LENGTH_LONG);
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                toast.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                v.setTextColor(Color.WHITE);
                v.setTextSize(20);
                toast.show();
                return true;
            case R.id.reset:
                Toast toast1 = Toast.makeText(getApplicationContext(),"Refreshed successfully!!",Toast.LENGTH_LONG);
                TextView v1 = (TextView) toast1.getView().findViewById(android.R.id.message);
                toast1.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                v1.setTextColor(Color.WHITE);
                v1.setTextSize(20);
                toast1.show();
                return true;
            case R.id.about:
                Toast toast2 = Toast.makeText(getApplicationContext(),"Application Version is 1.0", Toast.LENGTH_LONG);
                TextView v2 = (TextView) toast2.getView().findViewById(android.R.id.message);
                toast2.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                v2.setTextColor(Color.WHITE);
                v2.setTextSize(20);
                toast2.show();
                return true;
            case R.id.faq:
                Toast toast_faq = Toast.makeText(getApplicationContext()," // Need to be developed //", Toast.LENGTH_LONG);
                TextView faq = (TextView) toast_faq.getView().findViewById(android.R.id.message);
                toast_faq.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                faq.setTextColor(Color.WHITE);
                faq.setTextSize(20);
                toast_faq.show();
                return true;
            case R.id.exit:
                Toast toast3 = Toast.makeText(getApplicationContext(),"Logout successfully", Toast.LENGTH_LONG);
                TextView v3 = (TextView) toast3.getView().findViewById(android.R.id.message);
                toast3.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
                v3.setTextColor(Color.WHITE);
                v3.setTextSize(20);
                toast3.show();
               finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
