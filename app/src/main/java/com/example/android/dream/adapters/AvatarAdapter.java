package com.example.android.dream.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.dream.R;
import com.example.android.dream.models.Avatar;

import java.util.List;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder> {

    class AvatarViewHolder extends RecyclerView.ViewHolder {
        private final TextView avatarItemName;
        private final TextView descriptionItemName;
        private final TextView defenseItemName;
        private final TextView healthItemName;
        private final TextView strengthItemName;
        private final TextView agilityItemName;
        private final TextView intelligenceItemName;
        private final TextView finesseItemName;
        private final ImageView avatarItemImage;


        private AvatarViewHolder(View itemView) {
            super(itemView);
            avatarItemName = itemView.findViewById(R.id.avatarName);
            descriptionItemName = itemView.findViewById(R.id.description);
            defenseItemName = itemView.findViewById(R.id.defense);
            healthItemName = itemView.findViewById(R.id.health);
            strengthItemName = itemView.findViewById(R.id.strength);
            agilityItemName = itemView.findViewById(R.id.agility);
            intelligenceItemName = itemView.findViewById(R.id.intelligence);
            finesseItemName = itemView.findViewById(R.id.finesse);
            avatarItemImage = itemView.findViewById(R.id.avatarImage);
        }
    }


    private final LayoutInflater mInflater;
    private List<Avatar> mAvatar;

    public AvatarAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public AvatarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycler_item, parent, false);
        return new AvatarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AvatarViewHolder holder, final int position) {
        final Avatar current = mAvatar.get(position);
        holder.avatarItemImage.setImageResource(current.getAvatarPicture());
        holder.avatarItemName.setText(current.getName());

        holder.descriptionItemName.setText(current.getDescription());
        holder.defenseItemName.setText(("Defense: " + current.getDefense()));
        holder.healthItemName.setText(("Health: " + current.getHealth()));
        holder.strengthItemName.setText(("Str:\n" + current.getStrength()));
        holder.agilityItemName.setText(("Agility:\n" + current.getAgility()));
        holder.intelligenceItemName.setText(("Int:\n" + current.getIntelligence()));
        holder.finesseItemName.setText(("Finesse:\n" + current.getFinesse()));


    }


    public void setAvatar(List<Avatar> avatars) {
        mAvatar = avatars;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (mAvatar != null)
            return mAvatar.size();
        else return 0;
    }


}
