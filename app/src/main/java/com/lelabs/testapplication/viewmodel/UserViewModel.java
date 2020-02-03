package com.lelabs.testapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.lelabs.testapplication.app.TestAppClass;
import com.lelabs.testapplication.data.UserModel;
import com.lelabs.testapplication.retrofit.ApiClient;
import com.lelabs.testapplication.retrofit.ApiInterface;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by angeooo on 28-Jan-20.
 */
public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<UserModel>> getAllUsers() {

        final MutableLiveData<List<UserModel>> modelMutableLiveData = new MutableLiveData<>();
        ApiInterface apiService = ApiClient.getClient(TestAppClass.getContext()).create(ApiInterface.class);

        Call<List<UserModel>> call = apiService.get_homepage_data();
        String URL = call.request().url().toString();
        System.out.println("Retrofit URL : " + URL);
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<UserModel>> call, @NonNull retrofit2.Response<List<UserModel>> response) {
                if (response.code() == 200) {
                    List<UserModel> outputBean = response.body();
                    modelMutableLiveData.postValue(outputBean);
                } else modelMutableLiveData.postValue(Collections.emptyList());
            }
            @Override
            public void onFailure(@NonNull Call<List<UserModel>> call,@NonNull Throwable t) {
                modelMutableLiveData.postValue(Collections.emptyList());
            }
        });
        return modelMutableLiveData;
    }
}
