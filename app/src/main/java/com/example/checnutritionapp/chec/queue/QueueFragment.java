package com.example.checnutritionapp.chec.queue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueueFragment extends Fragment {

    private QueueViewModel queueViewModel;




     String mon= "\n Monday 02/03/2020                                           Total: $10.00\n\n [meal]: 2                                              Pickup:\n\n [meal]: 0                                             Time:";
    private Button Monday;
    private int M1=2;
    private int M2=0;
    private float M3=M1*5;
    private float M4=M2*5;
    private float TotalM=M3+M4;
    private String MMeal1="[Meal]";
    private String MMeal2="[Meal]";


    private String tues;
    private Button Tuesday;
    private int T1=0;
    private int T2=0;
    private float T3=T1*5;
    private float T4=T2*5;
    private float TotalT=T3+T4;
    private String TMeal1="[Meal]";
    private String TMeal2="[Meal]";



    private String wednes;
    private Button Wednesday;
    private int W1=0;
    private int W2=0;
    private float W3=W1*5;
    private float W4=W2*5;
    private float TotalW=W3+W4;
    private String WMeal1="[Meal]";
    private String WMeal2="[Meal]";



    private String thurs;
    private Button Thursday;
    private int R1=0;
    private int R2=0;
    private float R3=R1*5;
    private float R4=R2*5;
    private float TotalR=R3+R4;
    private String RMeal1="[Meal]";
    private String RMeal2="[Meal]";




    private float TotalMoney=(M1+M2+T1+T2+W1+W2+R1+R2)*5;

    String TM=String.format("%.2f",TotalMoney);
    String TMon=String.format("%.2f",TotalM);
    String TTues=String.format("%.2f",TotalT);
    String TWed=String.format("%.2f",TotalW);
    String TThurs=String.format("%.2f",TotalR);



    //SimpleDateFormat date= new SimpleDateFormat("MM/DD/YYYY");

    //String test = "\n Thursday 02/06/2020                                       Total: $0.00\n\n [meal]: 0                                              Pickup:\n\n [meal]: 0                                             Time:";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

          mon= "\n Monday 02/03/2020                                           Total: $"+TMon+"\n\n "+MMeal1+": "+M1+"                                              Pickup:\n\n "+MMeal2+": "+M2+"                                             Time:";

          tues= "\n Tuesday 02/04/2020                                           Total: $"+TTues+"\n\n "+TMeal1+": "+T1+"                                              Pickup:\n\n "+TMeal2+": "+T2+"                                             Time:";

          wednes= "\n Wednesday 02/05/2020                                           Total: $"+TWed+"\n\n "+WMeal1+": "+W1+"                                              Pickup:\n\n "+WMeal2+": "+W2+"                                             Time:";

          thurs= "\n Thursday 02/06/2020                                           Total: $"+TThurs+"\n\n "+RMeal1+": "+R1+"                                              Pickup:\n\n "+RMeal2+": "+R2+"                                             Time:";


        Monday = getView().findViewById(R.id.button7);
          Monday.setText(mon);


        Tuesday = getView().findViewById(R.id.button6);
        Tuesday.setText(tues);

        Wednesday = getView().findViewById(R.id.button2);
        Wednesday.setText(wednes);

        Thursday = getView().findViewById(R.id.button8);
        Thursday.setText(thurs);

        TextView textView=getView().findViewById(R.id.textView2);

        textView.setText("$ "+TM);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        queueViewModel =
                ViewModelProviders.of(this).get(QueueViewModel.class);
                View root = inflater.inflate(R.layout.activity_queue, container, false);
      //  final TextView textView = root.findViewById(R.id.nav_queue);

        //queueViewModel.getText().observe(this, new Observer<String>() {
          //  @Override
           //public void onChanged(@Nullable String s) {
               // textView.setText(s);
            //}

        //public void onCreate(Bundle saveInstanceState){

                //mon = Monday.getText().toString();
               // String Mon=mon;


       // }
        //});

        return root;
    }
}