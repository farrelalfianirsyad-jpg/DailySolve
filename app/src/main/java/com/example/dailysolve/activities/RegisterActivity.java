package com.example.dailysolve.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailysolve.R;
import com.example.dailysolve.api.ApiClient;
import com.example.dailysolve.api.ApiService;
import com.example.dailysolve.model.ResponseModel;

import retrofit2.*;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etEmail;
    EditText etPassword;

    Button btnRegister;
    Button btnBackLogin;

    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        apiService = ApiClient.getClient().create(ApiService.class);

        btnRegister.setOnClickListener(v -> registerUser());

        btnBackLogin = findViewById(R.id.btnBackLogin);

        btnBackLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void registerUser() {

        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // VALIDASI
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email wajib diisi");
            return;
        }

        if (!email.contains("@")) {
            etEmail.setError("Email tidak valid");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password wajib diisi");
            return;
        }

        if (password.length() < 4) {
            etPassword.setError("Minimal 4 karakter");
            return;
        }

        // CALL API REGISTER
        apiService.registerUser(username, email, password).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                Toast.makeText(RegisterActivity.this,
                        "Register berhasil",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,
                        "Error: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}