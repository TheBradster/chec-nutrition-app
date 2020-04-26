package com.example.checnutritionapp.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.MainActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.User;
import com.example.checnutritionapp.ui.user_profile.UserProfileFragment;

public class EditProfileFragment extends Fragment {

    private EditProfileViewModel mViewModel;
    private String Name;
    private String job;
    private String occ;
    private int fam;
    private String Fam;
    private String age;
    private String Age;
    private double foot;
    private int inch;
    private String height;
    private String CM;
    private double lbs;
    private String weight;
    private String KG;

    public static EditProfileFragment newInstance() {
        return new EditProfileFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_profile_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(EditProfileViewModel.class);
        MainActivity mainActivity = (MainActivity) getActivity();
        User user = mainActivity.getCurrentUser();
        Name = user.getFullName();
        job = user.getOccupation();
        fam = user.getFamilyCount();
        age=user.getAge();
        height=user.getHeight();
        CM=height.substring(0,height.length()-2);
        inch=Integer.parseInt(CM);
        foot=inch/30.48;
        weight=user.getWeight();
        KG=weight.substring(0,weight.length()-2);
        lbs=Integer.parseInt(KG);
        lbs=lbs/2.205;

        TextView name = getView().findViewById(R.id.FullName);
        TextView occupation = getView().findViewById(R.id.Occupation);
        TextView Height = getView().findViewById(R.id.Height);
        TextView Weight = getView().findViewById(R.id.Weight);
        TextView Age = getView().findViewById(R.id.Age);
        TextView family_size = getView().findViewById(R.id.FamilyCount);

        name.setText(Name);
        occupation.setText(job);
        Height.setText(height);
        Weight.setText(weight);
        Age.setText(age);
        family_size.setText(fam);

        Button openProfileFragment = (Button) v.findViewById(R.id.cancel_change);
        openProfileFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfileFragment profileFragment = new UserProfileFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.edit_layout, profileFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}
