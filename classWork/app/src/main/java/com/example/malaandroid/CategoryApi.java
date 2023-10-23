package com.example.malaandroid;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryApi {
    @GET("/api/categories/list")
    Call<List<Category>> getCategories();
}