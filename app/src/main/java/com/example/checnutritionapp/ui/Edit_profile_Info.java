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

public class Edit_profile_Info extends Fragment {

    private EditProfileInfoViewModel mViewModel;

    public static Edit_profile_Info newInstance() {
        return new Edit_profile_Info();
    }

    @Override
    public <User> View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                    @Nullable Bundle savedInstanceState) {
        String name;
        User u  = (User) getActivity().getIntent().getSerializableExtra(name: "User");
        View v = inflater.inflate(R.layout.edit_profile__info_fragment, container, false);
        String[] Users = u.getUsers();
        TextView[] vals = {v.findViewById(R.id.),
                v.findViewById(R.id.user_name_A),
                v.findViewById(R.id.emailID_A),
                v.findViewById(R.id.occupation_A),
                v.findViewById(R.id.height_A),
                v.findViewById(R.id.weight_A),
                v.findViewById(R.id.age_A),
                v.findViewById(R.id.family_size_A)};
        for (int i = 0; i < 13; i++) {
            vals[i].setText(Users[i]);
        }








        return v;
        //place all of the set.text under this
    }

    @Override
    public <User> void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditProfileInfoViewModel.class);
        // TODO: Use the ViewModel
        MainActivity mainActivity = (MainActivity) getActivity();
        User u = mainActivity.getCurrentUser();
    }

}
