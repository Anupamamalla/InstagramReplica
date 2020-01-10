package com.example.instagramreplica.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramreplica.R;
import com.example.instagramreplica.Url;
import com.example.instagramreplica.models.PostModel;
import com.example.instagramreplica.models.StoryModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    private List<StoryModel> listStories;
    private Context mContext;

    public StoryAdapter(List<StoryModel> listStories, Context mContext) {
        this.listStories = listStories;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.insta_story_card, parent, false);

        return new StoryViewHolder(view, mContext, listStories);
    }

    public void strict(){
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {

        StoryModel post = listStories.get(position);

        String imgPath = Url.BASE_URL + "uploads/" + post.getPhotos();
        strict();

        try{
            URL url;
            url = new URL(imgPath);
            holder.story.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        }catch (IOException e){
            e.printStackTrace();
        }
        holder.name .setText(post.getName());

    }

    @Override
    public int getItemCount() {
        return listStories.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{

        CircleImageView story, addStory;
        TextView name;
        Context mContext;
        List<StoryModel> list;

        public StoryViewHolder(@NonNull View itemView, final Context mContext, final List<StoryModel> list) {
            super(itemView);
            story = itemView.findViewById(R.id.imgInstaStory);
            name = itemView.findViewById(R.id.tvStoryBy);
            addStory = itemView.findViewById(R.id.imgInstaStoryAdd);
            this.mContext = mContext ;
            this.list = list;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StoryModel story = list.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + story.getName(), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
}

