package com.saravana.finance.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saravana.finance.R;
import com.saravana.finance.model.PartyModel;

import java.util.List;

/**
 * Created by THENNA on 3/24/2017.
 */
public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.ViewHolder> {

    private Activity mActivity;
    private List<PartyModel> users;

    public PartyAdapter(Activity mActivity, List<PartyModel> users) {
        this.mActivity = mActivity;
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mActivity).inflate(R.layout.party_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PartyModel user = users.get(position);
        holder.party_name.setText(user.getName());
        holder.finanace_Amount.setText(user.getAmount());
        holder.numberOfDues.setText(user.getDueDate());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

//        CircleImageView profileImg;
        TextView party_name;
        TextView finanace_Amount;
        TextView numberOfDues;

        public ViewHolder(View itemView) {
            super(itemView);
//            party_image = (CircleImageView) itemView.findViewById(R.id.party_image);
            party_name = (TextView) itemView.findViewById(R.id.party_name);
            finanace_Amount = (TextView) itemView.findViewById(R.id.finanace_Amount);
            numberOfDues = (TextView) itemView.findViewById(R.id.numberOfDues);
        }
    }


}
