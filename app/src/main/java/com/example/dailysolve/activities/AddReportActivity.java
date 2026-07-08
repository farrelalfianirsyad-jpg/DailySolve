package com.example.dailysolve.activities;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailysolve.R;
import com.example.dailysolve.api.*;
import com.example.dailysolve.model.*;

import retrofit2.*;

public class AddReportActivity extends AppCompatActivity {

    EditText etTitle, etDesc, etCategory;
    Button btnSave;
    ApiService apiService;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDesc);
        etCategory = findViewById(R.id.etCategory);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {

            finish();

        });

        apiService = ApiClient.getClient().create(ApiService.class);

        btnSave.setOnClickListener(v -> {

            String title = etTitle.getText().toString();
            String desc = etDesc.getText().toString();
            String cat = etCategory.getText().toString();

            if (title.isEmpty()) {
                etTitle.setError("Required");
                return;
            }

            apiService.addReport(title, desc, cat).enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                    Toast.makeText(AddReportActivity.this,
                            "Success",
                            Toast.LENGTH_SHORT).show();

                    finish();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(AddReportActivity.this,
                            "Error: " + t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}