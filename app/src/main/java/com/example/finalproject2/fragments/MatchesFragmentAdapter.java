package com.example.finalproject2.fragments;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject2.R;
import com.example.finalproject2.models.User;
import com.example.finalproject2.serverComunication.ServerCom;

import java.util.List;

public class MatchesFragmentAdapter extends RecyclerView.Adapter<MatchesFragmentAdapter.MyViewHolder> {

    public MatchesFragmentAdapter(List<User> data, Context c) {
        this.users = data;
        this.c = c;
    }

    public List<User> users = null;
    public Context c;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        TextView match_name;
        TextView text;

        ConstraintLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.match_number);
            match_name = itemView.findViewById(R.id.match_name);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_item, parent ,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text.setText(users.get(position).number);
        holder.match_name.setText(users.get(position).name);
    }

    public void removeAt(int position) {
       users.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, users.size());
    }
    @Override
    public int getItemCount() {
        return users.size();
    }
}
