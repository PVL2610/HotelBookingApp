package com.example.hotelbooking_app.Homescreen.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hotelbooking_app.Homescreen.HomescreenActivity;
import com.example.hotelbooking_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homescreen_about_us extends Fragment {
    ImageButton aboutus_btn_back;
    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homescreen_fragment_about_us, container, false);
        // back home
        aboutus_btn_back = (ImageButton) view.findViewById(R.id.myprofile_btn_back);
        bottomNavigationView = getActivity().findViewById(R.id.homescreen_bottom_navigation);

        // Set a click listener for the button
        aboutus_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add this line to go back to the previous fragment
                getFragmentManager().popBackStack();
                // Update the selected item in the BottomNavigationView
                bottomNavigationView.setSelectedItemId(((HomescreenActivity)getActivity()).getPreviousFragmentId());
            }

        });
        return view;

    }
}

