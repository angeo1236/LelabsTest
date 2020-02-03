package com.lelabs.testapplication.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lelabs.testapplication.R;
import com.lelabs.testapplication.data.UserModel;

/**
 * Created by angeooo on 28-Jan-20.
 */
public class UserDetailFragment extends BaseFragment {

    private UserModel userModel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
        TextView name_tv = view.findViewById(R.id.name_tv);
        TextView username_td = view.findViewById(R.id.username_td);
        TextView email_td = view.findViewById(R.id.email_td);
        TextView website_td = view.findViewById(R.id.website_td);
        TextView company_name_td = view.findViewById(R.id.company_name_td);
        TextView catchphrase_td = view.findViewById(R.id.catchphrase_td);
        TextView phone_td = view.findViewById(R.id.phone_td);
        TextView bs_td = view.findViewById(R.id.bs_td);
        TextView zip_td = view.findViewById(R.id.zip_td);
        TextView street_td = view.findViewById(R.id.street_td);
        TextView city_td = view.findViewById(R.id.city_td);
        TextView suite_td = view.findViewById(R.id.suite_td);
        TextView location_intent_td = view.findViewById(R.id.location_intent_td);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            userModel = (UserModel) bundle.getSerializable("UserObject");
        }


        if (userModel != null) {
            name_tv.setText(userModel.getName());
            phone_td.setText(userModel.getPhone());
            username_td.setText(userModel.getUsername());
            email_td.setText(userModel.getEmail());
            website_td.setText(userModel.getWebsite());
            company_name_td.setText(userModel.getCompany().getName());
            catchphrase_td.setText(userModel.getCompany().getCatchPhrase());
            bs_td.setText(userModel.getCompany().getBs());

            street_td.setText(userModel.getAddress().getStreet());
            zip_td.setText(userModel.getAddress().getZipcode());
            city_td.setText(userModel.getAddress().getCity());
            suite_td.setText(userModel.getAddress().getSuite());

            location_intent_td.setOnClickListener(v -> {
                showLocation(userModel.getAddress().getGeo().getLat(),userModel.getAddress().getGeo().getLng());
            });

        }
        return view;
    }

    private void showLocation(String lat,String lon){
        String mapUrl="http://maps.google.com/maps?saddr="+lat+"&daddr="+lon;
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(mapUrl));
        startActivity(intent);
    }
}
