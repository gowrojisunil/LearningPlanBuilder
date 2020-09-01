package com.learnplanbuilder.app.view;
/**
 * Created by Sunil gowroji
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
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
        theListView = findViewById(R.id.mainListView);


        // prepare elements to display
        final ArrayList<Item> itemlist = Item.getTestingList();

        // add custom btn handler to first list item
        itemlist.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Feature is not available, Pay with Google pay!!");
            }
        });

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this, itemlist);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Purchase completed successfully!!");
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


        switch (id) {
            case R.id.add:
                //  showToast("Please add your family members");
                Intent intent = new Intent(this, ViewFamilyMembersActivity.class);
                startActivity(intent);
                return true;
            case R.id.reset:
                showToast("Refreshed successfully!!");
                return true;
            case R.id.about:
                showToast("Application Version is 1.0");
                return true;
            case R.id.faq:
                showToast("FAQ & Feedback");
                return true;
            case R.id.exit:
                showToast("Logout Successfully !!");
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showToast(String DisplayString) {
        Toast toast = Toast.makeText(getApplicationContext(), DisplayString, Toast.LENGTH_LONG);
        TextView v3 = (TextView) toast.getView().findViewById(android.R.id.message);
        toast.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
        v3.setTextColor(Color.WHITE);
        v3.setTextSize(20);
        toast.show();
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
