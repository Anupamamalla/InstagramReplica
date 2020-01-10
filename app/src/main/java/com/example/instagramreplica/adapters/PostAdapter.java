package com.example.instagramreplica.adapters;

import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramreplica.R;
import com.example.instagramreplica.Url;
import com.example.instagramreplica.models.PostModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    private List<PostModel> list;

    public PostAdapter(List<PostModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.insta_post_card, parent, false);

        return new PostViewHolder(view);
    }

    public void strict(){
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel post = list.get(position);

        String imgPath = Url.BASE_URL + "uploads/" + post.getPost();
        String imgPath2 = Url.BASE_URL + "uploads/" + post.getAuthorPic();
        strict();

        try{
            URL url;
            url = new URL(imgPath);
            holder.imgPost.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            url = new URL(imgPath2);
            holder.imgProfilePicPost.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        }catch (IOException e){
            e.printStackTrace();
        }
        holder.tvUsername.setText(post.getPostBy());
        holder.tvCaption.setText(post.getCaption());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgProfilePicPost;
        ImageView imgPost;
        TextView tvUsername, tvCaption;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfilePicPost = itemView.findViewById(R.id.imgProfilePicPost);
            imgPost = itemView.findViewById(R.id.imgPost);
            tvCaption = itemView.findViewById(R.id.tvCaption);
            tvUsername = itemView.findViewById(R.id.tvUsername);

        }
    }

}
