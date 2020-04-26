package com.example.checnutritionapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private String name;
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_profile_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(EditProfileViewModel.class);
        MainActivity mainActivity = (MainActivity) getActivity();
        User user = mainActivity.getCurrentUser();
        name = user.getFullName();
        job = user.getOccupation();
        occ ="Occupation: "+job;
        fam = user.getFamilyCount();
        Fam = "Family Size: "+fam;
        age=user.getAge();
        Age="Age: "+age;
        height=user.getHeight();
        CM=height.substring(0,height.length()-2);
        inch=Integer.parseInt(CM);
        foot=inch/30.48;
        weight=user.getWeight();
        KG=weight.substring(0,weight.length()-2);
        lbs=Integer.parseInt(KG);
        lbs=lbs/2.205;

        TextView fullname = getView().findViewById(R.id.FullName);
        TextView occupation = getView().findViewById(R.id.Occupation);
        TextView Height = getView().findViewById(R.id.Height);
        TextView Weight = getView().findViewById(R.id.Weight);
        TextView age = getView().findViewById(R.id.Age);
        TextView family_size = getView().findViewById(R.id.FamilyCount);
        ImageView profile_pic = getView().findViewById(R.id.Profile_pic);

        fullname.setText(name);
        occupation.setText(occ);
        Height.setText(height);
        Weight.setText(weight);
        age.setText(Age);
        family_size.setText(fam);
        profile_pic.setImageResource(R.drawable.percyjackson);

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
