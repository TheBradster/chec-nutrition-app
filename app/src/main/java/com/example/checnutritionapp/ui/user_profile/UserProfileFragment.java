package com.example.checnutritionapp.ui.user_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.R;

public class UserProfileFragment extends Fragment {

    private UserProfileViewModel userProfileViewModel;

    private String Name;
    private String job;
    private String occ;
    private int fam;
    private String Fam;
    private int age;
    private String Age;
    private double bmi;
    private String BMI;
    private int foot;
    private int inch;
    private String height;
    private double lbs;
    private String weight;
    private int fbg;
    private String FBG;
    private double a1c;
    private String A1C;
    private int cholest;
    private String Cholest;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Name="Percy Jackson";

        job="Hero";

        occ="Occupation: "+job;

        fam=5;

        Fam="Family Size: "+fam;

        age=16;

        Age="Age: "+age;

        bmi=19.5;

        BMI="BMI: "+bmi;

        foot=5;

        inch=3;



        TextView name=getView().findViewById(R.id.textView8);

        TextView a=getView().findViewById(R.id.textView5);

        TextView b=getView().findViewById(R.id.textView7);

        ImageView image =getView().findViewById(R.id.imageView3);

        name.setText(Name);

        a.setText(Age);

        b.setText(BMI);

        image.setImageResource(R.drawable.percyjackson);

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userProfileViewModel =
                ViewModelProviders.of(this).get(UserProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_profile, container, false);
       // final TextView textView = root.findViewById(R.id.text_user_profile);
        //userProfileViewModel.getText().observe(this, new Observer<String>() {
            //@Override
           // public void onChanged(@Nullable String s) {
          //      textView.setText(s);
            //}
        //});
        return root;
    }
}