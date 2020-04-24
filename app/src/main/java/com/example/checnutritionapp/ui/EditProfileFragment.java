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

import com.example.checnutritionapp.R;

public class Edit_profile_Info<User> extends Fragment {

    private EditProfileViewModel mViewModel;

    public static Edit_profile_Info newInstance() {
        return new Edit_profile_Info();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

         User u = (User) getActivity().getIntent().getSerializableExtra(name:"User");
        View v = inflater.inflate(R.layout.edit_profile_fragment, container, false);
        String[] Users = u.getUsers();
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

