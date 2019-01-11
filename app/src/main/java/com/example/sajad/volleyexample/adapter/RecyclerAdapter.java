package com.example.sajad.volleyexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sajad.volleyexample.model.Anime;
import com.example.sajad.volleyexample.activity.AnimeDetail;
import com.example.sajad.volleyexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sajad on 8/2/2018.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>{

    private Context mContext;
    private List<Anime> mAnimes;

    public RecyclerAdapter(Context context, List<Anime> animes) {
        mContext = context;
        mAnimes = animes;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        Anime anime = mAnimes.get(position);
        holder.name.setText(anime.getName());
        holder.categorie.setText(anime.getCategorie());
        holder.rate.setText(anime.getRating());
        holder.studio.setText(anime.getStudio());
        Picasso.get().load(anime.getImage_url()).placeholder(R.drawable.rating_background).error(R.drawable.rating_background).into(holder.image);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send data to AnimeDetail activity
                Intent intent = new Intent(view.getContext(), AnimeDetail.class);
                intent.putExtra("name", mAnimes.get(position).getName());
                intent.putExtra("description", mAnimes.get(position).getDescription());
                intent.putExtra("categorie", mAnimes.get(position).getCategorie());
                intent.putExtra("rate", mAnimes.get(position).getRating());
                intent.putExtra("studio", mAnimes.get(position).getStudio());
                intent.putExtra("image", mAnimes.get(position).getImage_url());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAnimes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView categorie;
        private TextView rate;
        private TextView studio;
        private ImageView image;
        private LinearLayout linear;

        public ListViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            categorie = itemView.findViewById(R.id.categorie);
            rate = itemView.findViewById(R.id.rating);
            studio = itemView.findViewById(R.id.studio);
            image = itemView.findViewById(R.id.image);
            linear = itemView.findViewById(R.id.container);
        }
    }
}
