package com.example.lishu.meizi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lishu.meizi.R;
import com.example.lishu.meizi.models.MeiZi;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lishu on 2018/10/8.
 */

public class MeiZiListAdapter extends BaseListAdapter<MeiZi> {


    public MeiZiListAdapter(List<MeiZi> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MeiZi meizi = getItem(position);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_meizi,parent,false);
        }
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_meizi);
        Picasso.with(context).load(meizi.getUrl()).into(iv);
        return convertView;
    }

}
