package com.example.eteat_together;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayourmanager;
    private String[] myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        //use this setting to improve performance if you know that change
        //in content ddo not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        //use linear layout manager
        mLayourmanager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayourmanager);

        //specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

}

