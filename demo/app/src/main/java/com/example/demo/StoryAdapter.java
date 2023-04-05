package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> implements Filterable {

    private List<Story> storyList;
    private List<Story> filteredStoryList;
    private Context context;

    public StoryAdapter(MainActivity mainActivity, List<Story> storyList) {
        this.storyList = storyList;
        this.filteredStoryList = new ArrayList<>(storyList);
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        context = parent.getContext();
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story story = filteredStoryList.get(position);
        holder.titleTextView.setText(story.getTitle());
        holder.contentTextView.setText(story.getContent());
        holder.imageView.setImageResource(story.getImageResource());
    }

    @Override
    public int getItemCount() {
        return filteredStoryList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Story> filteredList = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(storyList);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (Story story : storyList) {
                        if (story.getTitle().toLowerCase().contains(filterPattern)) {
                            filteredList.add(story);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredStoryList.clear();
                filteredStoryList.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView contentTextView;
        private ImageView imageView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
};


