package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private List<Story> mStoryList;
    private StoryAdapter mStoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.searchView);
        mProgressBar = findViewById(R.id.recyclerView);

        mStoryList = new ArrayList<>();
        mStoryAdapter = new StoryAdapter(this, mStoryList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mStoryAdapter);

        new LoadStoryTask().execute();
    }

    private class LoadStoryTask extends AsyncTask<Void, Void, List<Story>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Story> doInBackground(Void... voids) {
            // Tải danh sách truyện từ server hoặc lưu trữ nội bộ
            List<Story> storyList = new ArrayList<>();
            storyList.add(new Story("Truyện 1", "Nội dung truyện 1", R.drawable.story1));
            storyList.add(new Story("Truyện 2", "Nội dung truyện 2", R.drawable.story2));
            storyList.add(new Story("Truyện 3", "Nội dung truyện 3", R.drawable.story3));
            storyList.add(new Story("Truyện 4", "Nội dung truyện 4", R.drawable.story4));
            storyList.add(new Story("Truyện 5", "Nội dung truyện 5", R.drawable.story5));
            return storyList;
        }

        @Override
        protected void onPostExecute(List<Story> storyList) {
            super.onPostExecute(storyList);
            mProgressBar.setVisibility(View.GONE);
            mStoryList.clear();
            mStoryList.addAll(storyList);
            mStoryAdapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Đã tải xong danh sách truyện", Toast.LENGTH_SHORT).show();
        }
    }
}
