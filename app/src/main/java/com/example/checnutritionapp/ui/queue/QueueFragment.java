package com.example.checnutritionapp.ui.queue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueueFragment extends Fragment {

    private QueueViewModel queueViewModel;

    private Date Mon= new SimpleDateFormat("MM/dd/yyyy").parse("02/03/2020");
    private Date Tues= new SimpleDateFormat("MM/dd/yyyy").parse("02/04/2020");
    private Date Wed= new SimpleDateFormat("MM/dd/yyyy").parse("02/05/2020");
    private Date Thurs= new SimpleDateFormat("MM/dd/yyyy").parse("02/06/2020");


    private Meal[] Meals={new Meal ("[Mon1]",5),new Meal("[Mon2]",5),
            new Meal("[Tues1]",5),new Meal("[Tues2]",5),
            new Meal("[Wed1]",5),new Meal("[Wed2]",5),
            new Meal("[Thu1]",5),new Meal("[Thu2]",5)};


    private Location [] Locations={new Location("Claremont High","1601 N Indian Hill Blvd, Claremont, CA 91711"),
            new Location("Ohio State University","Columbus, OH 43210"),
            new Location("University of Memphis","3720 Alumni Ave, Memphis, TN 38152"),
            new Location("University of Cincinnati","2600 Clifton Ave, Cincinnati, OH 45221")};


    private Order [] Orders={new Order (Mon,Meals),new Order (Tues,Meals),new Order (Wed,Meals),new Order (Thurs,Meals),};

    private Ticket [] Tickets  =Orders[0].getTickets();



    private String mon;
    private Button Monday;
    private int M1=2;
    private int M2=0;
    private double TotalM;


    private String tues;
    private Button Tuesday;
    private int T1=0;
    private int T2=0;
    private double TotalT;



    private String wednes;
    private Button Wednesday;
    private int W1=0;
    private int W2=0;
    private double TotalW;



    private String thurs;
    private Button Thursday;
    private int R1=0;
    private int R2=0;
    private double TotalR;




    private double TotalMoney;



    public QueueFragment() throws ParseException {
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Tickets[0].changeServing(M1);
        Tickets[1].changeServing(M2);

        Tickets[2].changeServing(T1);
        Tickets[3].changeServing(T2);

        Tickets[4].changeServing(W1);
        Tickets[5].changeServing(W2);

        Tickets[6].changeServing(R1);
        Tickets[7].changeServing(R2);

        TotalM=Tickets[0].total()+Tickets[1].total();
        TotalT=Tickets[2].total()+Tickets[3].total();
        TotalW=Tickets[4].total()+Tickets[5].total();
        TotalR=Tickets[6].total()+Tickets[7].total();

        TotalMoney=TotalM+TotalT+TotalW+TotalR;

        String TM=String.format("%.2f",TotalMoney);
        String TMon=String.format("%.2f",TotalM);
        String TTues=String.format("%.2f",TotalT);
        String TWed=String.format("%.2f",TotalW);
        String TThurs=String.format("%.2f",TotalR);

          mon= "\n "+Orders[0].getReadyDate()+"                             Total: $"+TMon+"\n\n "+Meals[0].getName()+": "+Tickets[0].numberOfServings()+"\n                          Pickup: "+Locations[0].getName()+" \n "+Meals[1].getName()+": "+Tickets[1].numberOfServings();

          tues= "\n "+Orders[1].getReadyDate()+"                             Total: $"+TTues+"\n\n "+Meals[2].getName()+": "+Tickets[2].numberOfServings()+"\n                          Pickup: "+Locations[1].getName()+" \n "+Meals[3].getName()+": "+Tickets[3].numberOfServings();

          wednes= "\n "+Orders[2].getReadyDate()+"                             Total: $"+TWed+"\n\n "+Meals[4].getName()+": "+Tickets[4].numberOfServings()+"\n                          Pickup: "+Locations[2].getName()+" \n "+Meals[5].getName()+": "+Tickets[5].numberOfServings();

          thurs= "\n "+Orders[3].getReadyDate()+"                             Total: $"+TThurs+"\n\n "+Meals[6].getName()+": "+Tickets[6].numberOfServings()+"\n                          Pickup: "+Locations[3].getName()+" \n "+Meals[7].getName()+": "+Tickets[7].numberOfServings();


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