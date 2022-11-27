package com.example.eteat_together;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<chatdata> mDataset;
    private String myNickName;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Textview_nickname;
        public TextView Textview_msg;
        public View rootView;
        public MyViewHolder(View v) {
            super(v);
            Textview_nickname =  v.findViewById(R.id.TextView_nickname);
            Textview_msg = v.findViewById(R.id.TextView_msg);
            rootView = v;

        }
    }

    public ChatAdapter(List<chatdata> myDataset, Context context, String myNickName)  {
        mDataset = myDataset;
        this.myNickName = myNickName;
    }

    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);
        MyViewHolder vh =new MyViewHolder(v);
        return vh;

    }

    @Override
    public  void onBindViewHolder(MyViewHolder holder, int position) {
        chatdata chat = mDataset.get(position);

        holder.Textview_nickname.setText(chat.getNickname());
        holder.Textview_msg.setText(chat.getMsg());

        if (chat.getNickname().equals(this.myNickName)) {
            holder.Textview_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            holder.Textview_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        else {
            holder.Textview_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            holder.Textview_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }
    }

    //Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset ==null ? 0 : mDataset.size();
    }
    public chatdata getChat(int position) {
        return mDataset != null ? mDataset.get(position) : null;
    }

    public void addChat(chatdata chat){
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1);
    }
}

