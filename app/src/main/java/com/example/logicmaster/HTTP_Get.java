package com.example.logicmaster;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HTTP_Get extends AppCompatActivity {
    private TextView myTextViewResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_get);

        myTextViewResult = findViewById(R.id.http_get_Text);
        OkHttpClient client = new OkHttpClient();
        String url = "https://reqres.in/api/users?page=2";
        String url2 = "https://panwafel.000webhostapp.com/test.json";

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
//                if (response.isSuccessful()){

//                }
                if(!response.isSuccessful()){
                    myTextViewResult.setText("Something went wrong.");
                }

                final String myResponse = response.body().string();

                HTTP_Get.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myTextViewResult.setText(myResponse);
                        Toast.makeText(HTTP_Get.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
