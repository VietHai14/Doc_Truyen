package com.example.appdoctruyentranh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.object.TruyenTranh;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private Context ct;
    private ArrayList<TruyenTranh> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//ghi chu
            convertView = inflater.inflate(R.layout.intem_truyen, null);
        }
        if (arr.size()>0){
            TruyenTranh truyenTranh= this.arr.get(position);
            TextView tenTruyenTranh=convertView.findViewById(R.id.TenTruyen);
            TextView tenTruyenChap=convertView.findViewById(R.id.TenChap);
            ImageView imgAnhTruyen=convertView.findViewById(R.id.imgAnhTruyen);

            tenTruyenTranh.setText(truyenTranh.getTenTruyen());
            tenTruyenChap.setText(truyenTranh.getTenChap());
            Glide.with(this.ct).load(truyenTranh.getLinkAnh()).into(imgAnhTruyen);//them tu git  dùng để gán link ảnh không cần dowload

        }
        return convertView;
    }
}
