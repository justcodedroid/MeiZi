package com.example.lishu.meizi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.lishu.meizi.adapter.MeiZiListAdapter;
import com.example.lishu.meizi.http.MeiZiService;
import com.example.lishu.meizi.models.BaseModel;
import com.example.lishu.meizi.models.MeiZi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements Callback<BaseModel<List<MeiZi>>> {

    private ListView lvMeizi;
    private List<MeiZi> meiZiList= new ArrayList<>();;
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.4:8888").addConverterFactory( GsonConverterFactory.create())
            .build();
    private MeiZiListAdapter meiZiListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        retrofit.create(MeiZiService.class).getMeiZis().enqueue(this);
    }

    private void initView() {
        lvMeizi = (ListView) findViewById(R.id.lv_meizi);
        meiZiListAdapter = new MeiZiListAdapter(meiZiList, this);
        lvMeizi.setAdapter(meiZiListAdapter);
    }

    @Override
    public void onResponse(Call<BaseModel<List<MeiZi>>> call, Response<BaseModel<List<MeiZi>>> response) {
        meiZiList.addAll(response.body().results);
        meiZiListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Call<BaseModel<List<MeiZi>>> call, Throwable t) {
    Log.e("error",t.getMessage());
    }
}
