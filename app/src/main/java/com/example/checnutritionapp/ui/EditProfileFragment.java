package com.example.checnutritionapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.MainActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.User;

public class EditProfileFragment extends Fragment {

    private EditProfileViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        MainActivity mainActivity = (MainActivity) getActivity();
        User u = mainActivity.getCurrentUser();
        View v = inflater.inflate(R.layout.edit_profile_fragment, container, false);
                u.getFullName(),
                u.getOccupation(),
                u.getHeight(),
                u.getWeight(),
                u.getAge(),
                u.getFamilyCount()};

}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditProfileViewModel.class);
    }

}

