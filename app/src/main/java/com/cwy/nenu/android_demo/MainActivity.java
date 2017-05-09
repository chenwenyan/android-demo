package com.cwy.nenu.android_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText editText = (EditText) findViewById(R.id.test);
    Button button = (Button) findViewById(R.id.doTest);
    TextView textView = (TextView) findViewById(R.id.result);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("MyTag","onClick");
                getTest();
            }
        });
    }

    //test request
    private void getTest(){
        String baseUrl = "http://localhost:8080";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TestService testService = retrofit.create(TestService.class);
        Call<JSONObject> call = testService.test(editText.getText().toString());
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                textView.setText(t.getMessage());
            }

        });
    }

}
