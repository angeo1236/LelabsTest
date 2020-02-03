package com.lelabs.testapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lelabs.testapplication.R;
import com.lelabs.testapplication.data.UserModel;
import com.lelabs.testapplication.interfaces.RecyclerViewInterface;
import com.lelabs.testapplication.utils.UtilMethods;

import java.util.ArrayList;
import java.util.List;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {


    RecyclerViewInterface viewInterface;
    private List<UserModel> userModelsList = new ArrayList<>();

    public UserListAdapter(RecyclerViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

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
        holder.letters_td.setText(UtilMethods.getFirstTwo(userModelsList.get(position).getName()));
        holder.name_tv.setText(userModelsList.get(position).getName());
        holder.full_layout.setOnClickListener(v -> {
            viewInterface.onItemClick(userModelsList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return userModelsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout full_layout;
        TextView phone_tv, name_tv, letters_td;


        public ViewHolder(View itemView) {
            super(itemView);

            letters_td = itemView.findViewById(R.id.letters_td);
            phone_tv = itemView.findViewById(R.id.phone_tv);
            name_tv = itemView.findViewById(R.id.name_tv);
            full_layout = itemView.findViewById(R.id.full_layout);
        }

    }
}