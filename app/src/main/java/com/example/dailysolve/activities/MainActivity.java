package com.example.dailysolve.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.dailysolve.R;
import com.example.dailysolve.api.ApiClient;
import com.example.dailysolve.api.ApiService;
import com.example.dailysolve.adapter.ReportAdapter;
import com.example.dailysolve.model.Report;

import java.util.List;

import retrofit2.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ReportAdapter adapter;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiService = ApiClient.getClient().create(ApiService.class);

        loadData();

        findViewById(R.id.btnAdd).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AddReportActivity.class))
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        apiService.getReports().enqueue(new Callback<List<Report>>() {
            @Override
            public void onResponse(Call<List<Report>> call, Response<List<Report>> response) {

                if (response.body() != null) {
                    adapter = new ReportAdapter(MainActivity.this, response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Report>> call, Throwable t) { }
        });
    }
}