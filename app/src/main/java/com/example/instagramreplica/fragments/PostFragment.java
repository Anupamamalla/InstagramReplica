package com.example.instagramreplica.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.instagramreplica.PostApi;
import com.example.instagramreplica.R;
import com.example.instagramreplica.StoryApi;
import com.example.instagramreplica.Url;
import com.example.instagramreplica.activities.MainActivity;
import com.example.instagramreplica.adapters.PostAdapter;
import com.example.instagramreplica.adapters.StoryAdapter;
import com.example.instagramreplica.models.PostModel;
import com.example.instagramreplica.models.StoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramreplica.activities.MainActivity.listStories;

public class PostFragment extends Fragment {


    //Story my add and retrieve
    //Post love count username manage profile pic

    RecyclerView recyclerView;
    RecyclerView rvStories;
    LinearLayoutManager layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        recyclerView = view.findViewById(R.id.postRecyclerView);
        rvStories = view.findViewById(R.id.rvStories);


        layout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        stories();
        posts();

        return view;
    }


    public void stories(){
        try{
            StoryApi story = Url.getInstance().create(StoryApi.class);
            Call<List<StoryModel>> storyCall = story.getStories();

            storyCall.enqueue(new Callback<List<StoryModel>>() {
                @Override
                public void onResponse(Call<List<StoryModel>> call, Response<List<StoryModel>> response) {
                    List<StoryModel> storyModel = response.body();

                    rvStories.setLayoutManager(layout);
                    StoryAdapter adapter = new StoryAdapter(storyModel, getContext());
                    rvStories.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<StoryModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    public void posts(){
        PostApi postApi = Url.getInstance().create(PostApi.class);
        Call<List<PostModel>> postCalls = postApi.getPosts();

        postCalls.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code: " + response.body(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<PostModel> list = response.body();

                PostAdapter adapter = new PostAdapter(list);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
