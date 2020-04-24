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

        TextView[] vals = {
                v.findViewById(R.id.user_name_B),
                v.findViewById(R.id.emailID_B),
                v.findViewById(R.id.occupation_B),
                v.findViewById(R.id.height_B),
                v.findViewById(R.id.weight_B),
                v.findViewById(R.id.age_B),
                v.findViewById(R.id.family_size_B)};
        for (int i = 0; i < 7; i++) {
            // vals[i].setText(Users[i]);
        }
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditProfileViewModel.class);
    }

}

