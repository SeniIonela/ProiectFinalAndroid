package com.example.finalproject2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject2.R;
import com.example.finalproject2.models.User;

import java.util.List;

public class MatchesRequestsFragment extends Fragment {

    private List<User> users;

    public MatchesRequestsFragment(List<User> users, Context c) {
        // Required empty public constructor
        this.users = users;
        this.c = c;
    }


    private RecyclerView rec = null;

    private Context c;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_potential_matches, container, false);
        rec = (RecyclerView) v.findViewById(R.id.potential_users_recycler);
        System.out.println("TOTAL USERS RETURNED TO MATCH REQUEst`s : " + users.size());
        rec.setAdapter(new MatchesRequestsFragmentAdapter(this.users, this.c));
        rec.setLayoutManager(new LinearLayoutManager(this.c));
        return v;
    }
}