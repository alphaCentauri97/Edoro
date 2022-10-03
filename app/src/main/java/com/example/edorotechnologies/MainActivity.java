package com.example.edorotechnologies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.edorotechnologies.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = RetrofitClass.getApiInterface();
        apiInterface.getData().enqueue(new Callback<ListClass>() {
            @Override
            public void onResponse(Call<ListClass> call, Response<ListClass> response) {
                if(response.isSuccessful()){
                    RecyclerAdpater adpater = new RecyclerAdpater(response.body().getData(), MainActivity.this);
                    binding.recylerView.setAdapter(adpater);
                }
            }

            @Override
            public void onFailure(Call<ListClass> call, Throwable t) {
                Toast.makeText(MainActivity.this, "E", Toast.LENGTH_SHORT).show();
            }
        });
    }
}