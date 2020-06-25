package com.example.finalproject2.fragments;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject2.R;
import com.example.finalproject2.models.User;
import com.example.finalproject2.serverComunication.ServerCom;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class PotentialFragmentAdapter extends RecyclerView.Adapter<PotentialFragmentAdapter.MyViewHolder> {

    public PotentialFragmentAdapter(List<User> data, Context c) {
        this.users = data;
        this.c = c;
    }

    public List<User> users = null;
    public Context c;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        Button rej;
        Button match;
        TextView text;

        ConstraintLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            rej = itemView.findViewById(R.id.rej_button);
            match = itemView.findViewById(R.id.match_button);
            text = itemView.findViewById(R.id.potential_user_name);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.potential_user_item_list, parent ,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text.setText(users.get(position).name);
        holder.rej.setOnClickListener(v -> {
            ServerCom.createMatch(()->{
                ((Activity)this.c).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        removeAt(position);
                    }
                });
            }, this.users.get(position).id, "false");
        });

        holder.match.setOnClickListener(v -> {
            ServerCom.createMatch(()->{
                ((Activity)this.c).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        removeAt(position);
                    }
                });
            }, this.users.get(position).id, "true");
        });
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
