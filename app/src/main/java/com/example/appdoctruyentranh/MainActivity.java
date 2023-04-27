package com.example.appdoctruyentranh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import com.example.appdoctruyentranh.adapter.TruyenTranhAdapter;
import com.example.appdoctruyentranh.object.TruyenTranh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;

    EditText  edtTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhxa();
        setup();
        setclick();
    }
    private void init(){
        truyenTranhArrayList =  new ArrayList<>();
        truyenTranhArrayList.add(new TruyenTranh("Truyện Doremon", "Chap1", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-truyen-tranh-doremon.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("ONE PIECE", "Chap2", "https://nettruyenco.vn/public/images/comics/one-piece.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện Pikachu", "Chap3", "https://img.wattpad.com/cover/308166178-256-k917965.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện cổ tích ", "Chap4", "data:image/jpeg;base64,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"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 1", "Chap1", "https://st.nettruyenvt.com/data/comics/166/ngao-thi-thien-dia.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 2", "Chap2", "https://st.nettruyenvt.com/data/comics/107/dai-phung-da-canh-nhan.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 3", "Chap3", "https://st.nettruyenvt.com/data/comics/233/cao-vo-ha-canh-den-mot-van-nam-sau.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 4", "Chap4", "https://st.nettruyenvt.com/data/comics/59/tieu-thiep-chi-muon-song-yen-binh.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 1", "Chap1", "https://st.nettruyenvt.com/data/comics/166/ngao-thi-thien-dia.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 2", "Chap2", "https://st.nettruyenvt.com/data/comics/107/dai-phung-da-canh-nhan.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 3", "Chap3", "https://st.nettruyenvt.com/data/comics/233/cao-vo-ha-canh-den-mot-van-nam-sau.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện 4", "Chap4", "https://st.nettruyenvt.com/data/comics/59/tieu-thiep-chi-muon-song-yen-binh.jpg"));

        adapter = new TruyenTranhAdapter(this,0,truyenTranhArrayList);
    }
    private void anhxa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }
    private void setup(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setclick(){
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString();
                adapter.sortTruyen(s);
            }
        });
    }

}