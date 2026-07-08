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

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle, tvDesc;
    TextView tvCategory;
    Button btnBack;
    Button btnDelete;
    Button btnEdit;

    int reportId;

    ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        tvCategory = findViewById(R.id.tvCategory);

        btnBack = findViewById(R.id.btnBack);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(v -> {

            Intent intent = new Intent(
                    DetailActivity.this,
                    EditReportActivity.class
            );


            intent.putExtra("id", reportId);
            intent.putExtra("title",
                    getIntent().getStringExtra("title"));

            intent.putExtra("desc",
                    getIntent().getStringExtra("desc"));

            intent.putExtra("category",
                    getIntent().getStringExtra("category"));


            startActivity(intent);

        });



        // ambil data dari adapter
        tvTitle.setText(getIntent().getStringExtra("title"));
        tvCategory.setText(getIntent().getStringExtra("category"));
        tvDesc.setText(getIntent().getStringExtra("desc"));


        reportId = getIntent().getIntExtra("id", 0);


        // koneksi API
        apiService = ApiClient.getClient()
                .create(ApiService.class);



        // tombol kembali
        btnBack.setOnClickListener(v -> {

            finish();
        });



        // tombol hapus laporan selesai
        btnDelete.setOnClickListener(v -> {


            if(reportId == 0){

                Toast.makeText(
                        DetailActivity.this,
                        "ID laporan tidak ditemukan",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }



            apiService.deleteReport(reportId)
                    .enqueue(new Callback<ResponseModel>() {

                        @Override
                        public void onResponse(
                                Call<ResponseModel> call,
                                Response<ResponseModel> response) {


                            Toast.makeText(
                                    DetailActivity.this,
                                    "Aktivitas selesai dan dihapus",
                                    Toast.LENGTH_SHORT
                            ).show();



                            Intent intent = new Intent(
                                    DetailActivity.this,
                                    MainActivity.class
                            );

                            startActivity(intent);
                            finish();

                        }



                        @Override
                        public void onFailure(
                                Call<ResponseModel> call,
                                Throwable t) {


                            Toast.makeText(
                                    DetailActivity.this,
                                    "Error : " + t.getMessage(),
                                    Toast.LENGTH_LONG
                            ).show();

                        }
                    });

        });

    }
}