package com.example.dailysolve.activities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailysolve.R;
import com.example.dailysolve.api.ApiClient;
import com.example.dailysolve.api.ApiService;
import com.example.dailysolve.model.ResponseModel;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditReportActivity extends AppCompatActivity {


    EditText etTitle, etDesc, etCategory;
    Button btnUpdate;

    ApiService apiService;

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDesc);
        etCategory = findViewById(R.id.etCategory);
        btnUpdate = findViewById(R.id.btnUpdate);



        apiService = ApiClient.getClient()
                .create(ApiService.class);



        id = getIntent().getIntExtra("id",0);



        etTitle.setText(
                getIntent().getStringExtra("title")
        );

        etDesc.setText(
                getIntent().getStringExtra("desc")
        );

        etCategory.setText(
                getIntent().getStringExtra("category")
        );



        btnUpdate.setOnClickListener(v -> {


            String title =
                    etTitle.getText().toString();

            String desc =
                    etDesc.getText().toString();

            String category =
                    etCategory.getText().toString();



            apiService.updateReport(
                    id,
                    title,
                    desc,
                    category
            ).enqueue(new Callback<ResponseModel>() {


                @Override
                public void onResponse(
                        Call<ResponseModel> call,
                        Response<ResponseModel> response) {


                    Toast.makeText(
                            EditReportActivity.this,
                            "Laporan berhasil diperbarui",
                            Toast.LENGTH_SHORT
                    ).show();


                    finish();

                }


                @Override
                public void onFailure(
                        Call<ResponseModel> call,
                        Throwable t) {


                    Toast.makeText(
                            EditReportActivity.this,
                            t.getMessage(),
                            Toast.LENGTH_LONG
                    ).show();

                }

            });

        });


    }

}