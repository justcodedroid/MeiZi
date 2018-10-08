package com.example.lishu.meizi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lishu.meizi.models.BaseModel;

import java.util.List;

/**
 * Created by lishu on 2018/10/8.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {
    Context context;
    List<T> datas;
    LayoutInflater inflater;
    public BaseListAdapter(List<T> datas,Context context) {
        this.datas = datas;
        this.context = context;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);


}
