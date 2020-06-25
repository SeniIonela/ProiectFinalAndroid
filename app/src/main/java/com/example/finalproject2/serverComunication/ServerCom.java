package com.example.finalproject2.serverComunication;

import com.example.finalproject2.models.User;
import com.example.finalproject2.state.AuthState;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ServerCom {
    public static String host = "http://192.168.64.2/server_app_mobile/";

    public static void login(String email, String password, LoginCallback callback) {

        System.out.println(host + "/login.php?email=" + email + "&password=" + password);
        Request req = new Request.Builder().url(host + "/login.php?email=" + email + "&password=" + password).build();
        OkHttpClient client = new OkHttpClient();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("==========================");
                String json_response = response.body().string();
                System.out.println(json_response);

                User user = new GsonBuilder().create().fromJson(json_response, User.class);

                callback.run(user);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }


    public static void getPotentialMatches(PotentialMatchesCallback callback) {
        Request req = new Request.Builder().url(host + "/get_potential_matches.php?user_id=" + AuthState.loggedinUser.id).build();
        OkHttpClient client = new OkHttpClient();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("==========================");
                String json_response = response.body().string();
                System.out.println(json_response);

                List<User> users = new GsonBuilder().create().fromJson(json_response, new TypeToken<List<User>>() {
                }.getType());
                callback.run(users);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }

    public static void getMatchRequests(PotentialMatchesCallback callback) {
        Request req = new Request.Builder().url(host + "get_match_requets.php?user_id=" + AuthState.loggedinUser.id).build();
        OkHttpClient client = new OkHttpClient();
        System.out.println(host + "get_match_requets.php?user_id=" + AuthState.loggedinUser.id);
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("==============MATCHES REQUESTS============");
                String json_response = response.body().string();
                System.out.println(json_response);
                List<User> users = new GsonBuilder().create().fromJson(json_response, new TypeToken<List<User>>() {
                }.getType());
                callback.run(users);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }

    public static void getMatches(PotentialMatchesCallback callback) {
        Request req = new Request.Builder().url(host + "/get_matches.php?user_id=" + AuthState.loggedinUser.id).build();
        OkHttpClient client = new OkHttpClient();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("============GET MATCHES==============");
                String json_response = response.body().string();
                System.out.println(json_response);

                List<User> users = new GsonBuilder().create().fromJson(json_response, new TypeToken<List<User>>() {
                }.getType());
                callback.run(users);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }

    public static void respondMatch(RespondMatchCallback callback, Integer match_user_id, String match) {
        Request req = new Request.Builder().url(host + "/respond_match.php?user_id=" + match_user_id + "&match_user_id=" + AuthState.loggedinUser.id + "&match=" + match).build();
        System.out.println(host + "/respond_match.php?user_id=" + AuthState.loggedinUser.id + "&match_user_id=" + match_user_id + "&match=" + match);
        OkHttpClient client = new OkHttpClient();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("==========================");
                String json_response = response.body().string();
                System.out.println(json_response);
                callback.run();
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }

    public static void createMatch(CreateMatchCallback callback, Integer user_id, String match) {
        Request req = new Request.Builder().url(host + "/create_match.php?user_id=" + AuthState.loggedinUser.id + "&match_user_id=" + user_id + "&match=" + match).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("==========================");
                String json_response = response.body().string();
                System.out.println(json_response);
                callback.run();
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }

    public static void register(RegisterCallback callback, String name, String email, String password, String phoneNr) {
        Request req = new Request.Builder().url(host + "/register.php?name=" + name + "&email=" + email + "&password=" + password + "&number=" + phoneNr).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("==========================");
                String json_response = response.body().string();
                System.out.println(json_response);
                User user = new GsonBuilder().create().fromJson(json_response, User.class);
                callback.run(user);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("////////////////////////////////");

                System.out.println(e.getMessage().toString());
            }
        });
    }
}
