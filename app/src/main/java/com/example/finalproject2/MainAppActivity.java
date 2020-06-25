package com.example.finalproject2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.finalproject2.fragments.MatchesFragment;
import com.example.finalproject2.fragments.MatchesRequestsFragment;
import com.example.finalproject2.fragments.PotentialMatchesFragment;
import com.example.finalproject2.models.User;
import com.example.finalproject2.serverComunication.ServerCom;

import java.util.List;

public class MainAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_app_activity_layout);

        ServerCom.getPotentialMatches((List<User> users) -> {
            PotentialMatchesFragment potFragment = new PotentialMatchesFragment(users, this);
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame_layout, potFragment).commit();
        });
    }

    public void removeAllFragments(){
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    public void openMatchRequests(View view) {
        removeAllFragments();
        ServerCom.getMatchRequests((List<User> users) -> {
            MatchesRequestsFragment potFragment = new MatchesRequestsFragment(users, this);
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame_layout, potFragment).commit();
        });
    }

    public void openPotentialMatchesFragment(View view) {
        removeAllFragments();
        ServerCom.getPotentialMatches((List<User> users) -> {
            PotentialMatchesFragment potFragment = new PotentialMatchesFragment(users, this);
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame_layout, potFragment).commit();
        });
    }

    public void openMatchedUsersFragment(View view) {
        removeAllFragments();
        ServerCom.getMatches((List<User> users) -> {
            MatchesFragment potFragment = new MatchesFragment(users, this);
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame_layout, potFragment).commit();
        });
    }
}
