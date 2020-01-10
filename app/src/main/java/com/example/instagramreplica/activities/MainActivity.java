package com.example.instagramreplica.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.example.instagramreplica.PostApi;
import com.example.instagramreplica.R;
import com.example.instagramreplica.StoryApi;
import com.example.instagramreplica.Url;
import com.example.instagramreplica.models.PostModel;
import com.example.instagramreplica.models.StoryModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmNav;

    public static List<PostModel> listPosts = new ArrayList<>();
    public static List<StoryModel> listStories = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btmNav = findViewById(R.id.nav_view);

        getSupportActionBar().hide();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_add, R.id.navigation_liked, R.id.navigation_profile
        ).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(btmNav, navController);



//        listPosts.add(new PostModel("1","Ironman", "I am ironman.", "R.drawable.ironman", "R.drawable.ironman"));
//        listPosts.add(new PostModel("2","Captain America", "I can do this all day", "R.drawable.captain", "R.drawable.captain"));
//        listPosts.add(new PostModel("3","Thor", "God of thunder", "R.drawable.thor", "R.drawable.thor"));
//        listPosts.add(new PostModel("4","Black Widow", "See you in a minute.", "R.drawable.blackwidow", "R.drawable.blackwidow"));


//        listStories.add(new StoryModel("1","Ironman", "R.drawable.ironman", "0"));
//        listStories.add(new StoryModel("Black Widow", "R.drawable.blackwidow"));
//        listStories.add(new StoryModel("2","Thor", "R.drawable.thor", "0"));
//        listStories.add(new StoryModel("Hwakeye", "R.drawable.hwakeye"));
//        listStories.add(new StoryModel("Captain America", "R.drawable.captain"));

    }

}