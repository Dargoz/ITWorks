package com.dargoz.itworks.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dargoz.itworks.R;
import com.dargoz.itworks.list.models.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroViewHolder> {

    List<Hero> heroes = new ArrayList<>();


    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.hero_item_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    protected class HeroViewHolder extends RecyclerView.ViewHolder {
        private final ImageView heroImage;
        private final TextView heroName;
        private final TextView heroDesc;


        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            heroImage = itemView.findViewById(R.id.hero_image);
            heroName = itemView.findViewById(R.id.hero_name);
            heroDesc = itemView.findViewById(R.id.hero_desc);
        }

        public void bindView(int position) {
            heroImage.setImageResource(heroes.get(position).imageResId);
            heroName.setText(heroes.get(position).name);
            heroDesc.setText(heroes.get(position).desc);
        }
    }

}
