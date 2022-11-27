package com.example.eteat_together;

import static java.security.AccessController.getContext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Textview_Title;
        public TextView Textview_Content;
        public ImageView Imageview_title;
        public MyViewHolder(View v) {
            super(v);
            Textview_Title =  v.findViewById(R.id.ImageView_title);
            Textview_Content = v.findViewById(R.id.TextView_content);
            Imageview_title = v.findViewById(R.id.ImageView_title);
        }
    }

    public MyAdapter(String[] myDataset)  {
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler, parent, false);
        MyViewHolder vh =new MyViewHolder(v);
        return vh;

    }

    @Override
    public  void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Textview_Title.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() { return mDataset.length; }
}

