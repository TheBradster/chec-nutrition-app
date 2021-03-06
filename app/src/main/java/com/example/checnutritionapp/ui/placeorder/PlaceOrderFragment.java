package com.example.checnutritionapp.ui.placeorder;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.checnutritionapp.activities.PlaceOrderActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Location;
import com.example.checnutritionapp.model.Order;
import com.example.checnutritionapp.model.Ticket;
import com.example.checnutritionapp.utility.JSONUtilities;

import org.json.JSONException;

public class PlaceOrderFragment extends Fragment implements View.OnClickListener {

    private PlaceOrderViewModel mViewModel;

    private Order mOrder;

    public static PlaceOrderFragment newInstance() {
        return new PlaceOrderFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.place_order_fragment, container, false);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlaceOrderViewModel.class);

        // Get order object from intent
        mOrder = (Order) getActivity().getIntent().getSerializableExtra("Order");
        Log.d(getClass().toString(), mOrder.toString()); // We have object

        // Set placeholder images with respective meal object references
        PlaceOrderActivity mainActivity = (PlaceOrderActivity) getActivity();
        String p = mainActivity.getApplicationContext().getPackageName();

        ImageView leftMeal = (ImageView) mainActivity.findViewById(R.id.order_meal_1);
        ImageView rightMeal = (ImageView) mainActivity.findViewById(R.id.order_meal_2);

        setMealImage(leftMeal,0, p);
        setMealImage(rightMeal,1, p);

        // Get buttons and set on click listener
        Button plus1 = (Button) getView().findViewById(R.id.plus1);
        plus1.setOnClickListener(this);
        Button plus2 = (Button) getView().findViewById(R.id.plus2);
        plus2.setOnClickListener(this);
        Button minus1 = (Button) getView().findViewById(R.id.minus1);
        minus1.setOnClickListener(this);
        Button minus2 = (Button) getView().findViewById(R.id.minus2);
        minus2.setOnClickListener(this);

        // Set up location dropdown
        Spinner locationSelect = getView().findViewById(R.id.location);

        // Import locations from JSON file
        Location[] locations = null;
        try {
            locations = Location.convertLocationList(JSONUtilities.loadJSONFromAsset(getContext(),"test_locations.json"));
        } catch (JSONException e) {
            getActivity().setResult(Activity.RESULT_CANCELED);
            getActivity().finish();
            e.printStackTrace();
        }

        ArrayAdapter<Location> adpt = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, locations);
        locationSelect.setAdapter(adpt);

        // Create listener to change listed address
        AdapterView.OnItemSelectedListener selectListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Location location = (Location) parent.getSelectedItem();
                // update underlying object
                mOrder.setLocation(location);
                // update text view to display pickup address
                TextView address = getView().findViewById(R.id.address);
                address.setText(location.getAddress());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        // Set location to default at previously chosen location if we're editing
        if (mOrder.getLocation() != null) {
            locationSelect.setSelection(mOrder.getLocation().getID());
        }
        locationSelect.setOnItemSelectedListener(selectListener);

        // Set correct pickup time
        TextView pickupTime = getView().findViewById(R.id.pickupTime);
        pickupTime.setText("Between 5:00 PM and 7:00 PM on " + mOrder.pickupDayOfWeek());

        // Place order button
        Button placeOrder = getView().findViewById(R.id.placeorderbutton);
        if (mOrder.orderTotal() != 0) {
            placeOrder.setText("UPDATE ORDER");
        }
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PlaceOrderFragment", "Order Placed\n" + mOrder.toString());
                // Only place orders if there are items selected
                if (mOrder.orderTotal() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("Order", mOrder);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                }
                else {
                    getActivity().setResult(Activity.RESULT_CANCELED);
                }
                getActivity().finish();
            }
        });

        // Cancel order button
        Button cancelOrder = getView().findViewById(R.id.cancelorderbutton);
        if (mOrder.orderTotal() == 0) { // Hide if new order
            cancelOrder.setVisibility(View.GONE);
        }
        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Order", (Bundle) null);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        });

        updateServing();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Ticket[] tickets = mOrder.getTickets();
        Log.d("PlaceOrderFramgment", "Yay, Buttons!!!");
        switch (id) {
            case R.id.plus1: tickets[0].changeServing(1); break;
            case R.id.plus2: tickets[1].changeServing(1); break;
            case R.id.minus1: tickets[0].changeServing(-1); break;
            case R.id.minus2: tickets[1].changeServing(-1); break;
            default: Log.wtf("PlaceOrderFragment", "WTF");
        }
        updateServing();
        Log.d(getClass().toString(), mOrder.toString());
    }

    private void updateServing() {
        TextView servings1 = (TextView) getView().findViewById(R.id.servings1);
        servings1.setText(String.valueOf(mOrder.getTickets()[0].numberOfServings()));
        TextView servings2 = (TextView) getView().findViewById(R.id.servings2);
        servings2.setText(String.valueOf(mOrder.getTickets()[1].numberOfServings()));
        TextView total = getView().findViewById(R.id.total);
        total.setText("Total: $" + String.format("%.2f", mOrder.orderTotal()));
    }

    private void setMealImage(ImageView img, int i, String p) {
        String f = mOrder.getTickets()[i].getMeal().getImageNameRef();
        int id = getResources().getIdentifier(p + ":drawable/" + f,null,null);
        img.setImageResource(id);
    }

}
