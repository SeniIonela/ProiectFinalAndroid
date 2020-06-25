package com.example.finalproject2.serverComunication;

import com.example.finalproject2.models.User;

import java.util.List;

public interface MatchesCallback {
    void run(List<User> users);
}
