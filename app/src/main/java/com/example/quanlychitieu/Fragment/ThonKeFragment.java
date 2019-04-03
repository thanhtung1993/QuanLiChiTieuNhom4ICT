package com.example.quanlychitieu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.ThisMonthActivity;
import com.example.quanlychitieu.ThisWeekActivity;
import com.example.quanlychitieu.ThisYearActitvity;
import com.example.quanlychitieu.TodayActivity;


public class ThonKeFragment extends Fragment implements View.OnClickListener {


    CardView Cardviewtoday,Cardviewthisweek,Cardviewthismonth,Cardviewthisyear;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongke, container, false);
        Cardviewtoday=view.findViewById(R.id.Carviewtoday);
        Cardviewthisweek=view.findViewById(R.id.Cardviewthisweek);
        Cardviewthismonth=view.findViewById(R.id.CardViewthismonth);
        Cardviewthisyear=view.findViewById(R.id.CardViewthisyear);
        Cardviewtoday.setOnClickListener(this);
        Cardviewthisweek.setOnClickListener(this);
        Cardviewthismonth.setOnClickListener(this);
        Cardviewthisyear.setOnClickListener(this);

       return view;

    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        int id=view.getId();
        switch (id){
            case R.id.Carviewtoday:
                Fragment fragment = new TodayActivity();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.Cardviewthisweek:
                Fragment fragmentweek = new ThisWeekActivity();

                FragmentTransaction fragmentTransactionweek = fragmentManager.beginTransaction();
                fragmentTransactionweek.replace(R.id.content, fragmentweek);
                fragmentTransactionweek.addToBackStack(null);
                fragmentTransactionweek.commit();
                break;

            case R.id.CardViewthismonth:
                Fragment fragmentmonth = new ThisMonthActivity();

                FragmentTransaction fragmentTransactionmonth = fragmentManager.beginTransaction();
                fragmentTransactionmonth.replace(R.id.content, fragmentmonth);
                fragmentTransactionmonth.addToBackStack(null);
                fragmentTransactionmonth.commit();
                break;

            case R.id.CardViewthisyear:
                Fragment fragmentyear = new ThisYearActitvity();
                FragmentTransaction fragmentTransactionyear = fragmentManager.beginTransaction();
                fragmentTransactionyear.replace(R.id.content, fragmentyear);
                fragmentTransactionyear.addToBackStack(null);
                fragmentTransactionyear.commit();
                break;

        }
    }
}
