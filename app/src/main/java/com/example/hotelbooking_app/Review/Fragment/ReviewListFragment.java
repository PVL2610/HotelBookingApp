package com.example.hotelbooking_app.Review.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelbooking_app.R;
import com.example.hotelbooking_app.Review.Adapter.ReviewAdapter;
import com.example.hotelbooking_app.Review.ReviewsActivity;
import com.example.hotelbooking_app.Review.dto.ReviewResponse;

import java.util.List;

public class ReviewListFragment extends Fragment {
    private List<ReviewResponse> reviews;

    public ReviewListFragment(List<ReviewResponse> reviews) {
        this.reviews = reviews;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.i("ReviewListFragment", "size: "+ reviews.size());
        View view = (View) inflater.inflate(R.layout.review_list_fragment, null);

        RecyclerView recyclerView = view.findViewById(R.id.review_recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ReviewAdapter adapter = new ReviewAdapter(reviews);
        recyclerView.setAdapter(adapter);
        return  view;
    }




}
