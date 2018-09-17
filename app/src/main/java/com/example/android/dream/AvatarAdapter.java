package com.example.android.dream;

import android.animation.ValueAnimator;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder>  {
    private AvatarDao dao;
    private Boolean notExpanded = true;
private ViewGroup mContainerView;


    class AvatarViewHolder extends RecyclerView.ViewHolder {

        private final TextView avatarItemName;
        private final TextView descriptionItemName;
        private final TextView defenseItemName;
        private final ImageView avatarItemImage;
        private final ImageView expandImageView;
        private final ImageView collapseImageView;





        private AvatarViewHolder(View itemView) {
            super(itemView);
            avatarItemName = itemView.findViewById(R.id.avatarName);
            descriptionItemName = itemView.findViewById(R.id.description);
            defenseItemName = itemView.findViewById(R.id.defense);
            avatarItemImage = itemView.findViewById(R.id.avatarImage);
            mContainerView =itemView.findViewById(R.id.expand_view);
            expandImageView = itemView.findViewById(R.id.expand_item);
            collapseImageView = itemView.findViewById(R.id.collapse_item);
        }
    }


    private final LayoutInflater mInflater;
    private List<Avatar> mAvatar;

    AvatarAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public AvatarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycler_item, parent, false);
        return new AvatarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AvatarViewHolder holder, int position) {
        final Avatar current = mAvatar.get(position);

        holder.avatarItemImage.setImageResource(current.getAvatarPicture());
        holder.avatarItemName.setText(current.getName());

       holder.collapseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContainerView.getContext(),"You Clicked me twice" , Toast.LENGTH_LONG).show();
                collapse(mContainerView);
                holder.expandImageView.setVisibility(View.VISIBLE);
                holder.collapseImageView.setVisibility(View.GONE);
//                holder.descriptionItemName.setVisibility(View.GONE);

           }
       });
        holder.expandImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContainerView.getContext(),"You Clicked me" , Toast.LENGTH_LONG).show();

                expand(mContainerView);
                holder.descriptionItemName.setText(current.getDescription());
//               holder.defenseItemName.setText(current.getDefense());
                holder.expandImageView.setVisibility(View.GONE);
                holder.collapseImageView.setVisibility(View.VISIBLE);
            }
        });

    }
    void setAvatar(List<Avatar> avatars) {
        mAvatar = avatars;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mAvatar != null)
            return mAvatar.size();
        else return 0;
    }
    public static void expand(final View v) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}
