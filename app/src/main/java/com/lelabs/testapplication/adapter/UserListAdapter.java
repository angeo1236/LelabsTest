package com.lelabs.testapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.lelabs.testapplication.R;
import com.lelabs.testapplication.data.UserModel;

import java.util.ArrayList;
import java.util.List;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {


    private List<UserModel> userModelsList=new ArrayList<>();



    public List<UserModel> getStudentist() {
        return userModelsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(v);
    }

    public void setDataList(List<UserModel> userModelsList) {
        this.userModelsList = userModelsList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.phone_tv.setText(userModelsList.get(position).getPhone());
        holder.name_tv.setText(userModelsList.get(position).getName());
        holder.full_layout.setOnClickListener(v->{
//            MainActivity.
        });
    }

    @Override
    public int getItemCount() {
        return userModelsList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout full_layout;
        TextView phone_tv, name_tv;


        public ViewHolder(View itemView) {
            super(itemView);

            phone_tv = itemView.findViewById(R.id.phone_tv);
            name_tv = itemView.findViewById(R.id.name_tv);
            full_layout = itemView.findViewById(R.id.full_layout);
        }

    }
}