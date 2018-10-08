package com.example.lishu.meizi.http;

import com.example.lishu.meizi.models.BaseModel;
import com.example.lishu.meizi.models.MeiZi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by lishu on 2018/10/8.
 */

public interface MeiZiService {
    @GET("meizi")
    Call<BaseModel<List<MeiZi>>> getMeiZis();
}
