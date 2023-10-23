package com.example.malaandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://spu123.itstep.click";
    private ImageView imgAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAvatar=findViewById(R.id.imgAvatar);
        String url = "https://kovbasa.itstep.click/images/mala.jpeg";
        Glide
                .with(this)
                .load(url)
                .apply(new RequestOptions().override(600))
                .into(imgAvatar);
        GetCategories();
    }

    public void GetCategories() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryApi categoryApi = retrofit.create(CategoryApi.class);

        Call<List<Category>> call = categoryApi.getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    List<Category> categories = response.body();
                    for (Category category : categories) {
                        Log.d("Category", "ID: " + category.getId());
                        Log.d("Category", "name: " + category.getName());
                        Log.d("Category", "description: " + category.getDescription());
                        Log.d("Category", "image: " + category.getImage());
                    }
                } else {
                    Log.e("API error", "Failed to fercth");
                }
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t){
                    Log.e("API error", "API call failed", t);
                }
        });
        }

}