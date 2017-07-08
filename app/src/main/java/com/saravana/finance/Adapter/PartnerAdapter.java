package com.saravana.finance.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saravana.finance.R;
import com.saravana.finance.model.PartnersModel;

import java.util.List;

/**
 * Created by THENNA on 3/24/2017.
 */
public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.ViewHolder> {

    private Activity mActivity;
    private List<PartnersModel> users;

    public PartnerAdapter(Activity mActivity, List<PartnersModel> users) {
        this.mActivity = mActivity;
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mActivity).inflate(R.layout.partner_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PartnersModel user = users.get(position);
        holder.username.setText(user.getPartnername());
        holder.lastMsg.setText("Hi");

//        Glide.with(mActivity).load(user.getPhotoUrl()).into(holder.profileImg);


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

//        CircleImageView profileImg;
        TextView username;
        TextView lastMsg;

        public ViewHolder(View itemView) {
            super(itemView);
//            profileImg = (CircleImageView) itemView.findViewById(R.id.profile_img);
            username = (TextView) itemView.findViewById(R.id.username);
            lastMsg = (TextView) itemView.findViewById(R.id.last_msg);
        }
    }


}
