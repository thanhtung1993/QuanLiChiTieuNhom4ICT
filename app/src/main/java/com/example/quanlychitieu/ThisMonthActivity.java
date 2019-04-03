package com.example.quanlychitieu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.quanlychitieu.Database.DatabaseKhoanChi;
import com.example.quanlychitieu.Database.DatabaseKhoanThu;
import com.example.quanlychitieu.Database.DatabaseTaiKhoan;
import com.example.quanlychitieu.Model.ModelKhoanChi;
import com.example.quanlychitieu.Model.ModelKhoanThu;
import com.example.quanlychitieu.Model.ModelTaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class ThisMonthActivity extends Fragment {

    DatabaseKhoanChi databaseKhoanChi;
    DatabaseKhoanThu databaseKhoanThu;
    DatabaseTaiKhoan databaseTaiKhoan;
    List<ModelKhoanThu> listTodayThu;
    List<ModelKhoanChi> listTodayChi;
    List<ModelTaiKhoan> listModelTaiKhoan;
   // private PieChart mChart;
    private float TongThuChiCu,TongThuChiMoi,TongThuChi,tongChi,tongThu;

    private float [] yData;
    String a="Tổng Khoản Thu";
    String b="Tổng Khoản Chi";
    String c="Tổng Thu Chi";
    private String [] xData;
    String y="";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.this_month_fragment,container,false);
        databaseKhoanChi=new DatabaseKhoanChi(getContext());
        databaseKhoanThu=new DatabaseKhoanThu(getContext());
        databaseTaiKhoan=new DatabaseTaiKhoan(getContext());
        listTodayThu=new ArrayList<>();
        listTodayChi=new ArrayList<>();
        listModelTaiKhoan =new ArrayList<>();
       // mChart=view.findViewById(R.id.chartMonth);

        tongThu=0;
        listTodayThu=databaseKhoanThu.getKhoangThuTheoNgayThangNam(databaseKhoanThu.ThisMonth);
        Log.d("Month Khoản Thu", String.valueOf(listTodayThu.size()));
        for (ModelKhoanThu modelKhoanThu : listTodayThu){
            tongThu+=(Float.parseFloat(modelKhoanThu.getSoTien()));
        }

        tongChi=0;
        listTodayChi=databaseKhoanChi.getKhoangChiTheoNgayThangNam(databaseKhoanChi.ThisMonth);
        Log.d("Month Khoản Chi", String.valueOf(listTodayChi.size()));
        for (ModelKhoanChi modelKhoanChi : listTodayChi){

            tongChi+=(Float.parseFloat(modelKhoanChi.getSoTienChi()));
        }
        TongThuChi=0;
      /* mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getActivity(), ""+e.getY(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        listTaiKhoan=databaseTaiKhoan.getTaiKhoan();
        for (TaiKhoan taiKhoan:listTaiKhoan)
        {
            TongThuChi+=Float.parseFloat(taiKhoan.getSoTienTaiKhoan());

        }

        yData= new float[]{tongThu,tongChi,TongThuChi};


        xData=new String[]{a,b,c};
        final List<PieEntry> pieEntriesY=new ArrayList<>();

        for (int i=0; i<yData.length;i++){
            pieEntriesY.add(new PieEntry((float) yData[i],xData[i]));

        }

        PieDataSet dataset =new PieDataSet(pieEntriesY,"");


        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setValueTextSize(15f);
        dataset.setSliceSpace(3);
        dataset.setSelectionShift(5);
        dataset.setValueTextColor(Color.RED);
        final PieData data=new PieData(dataset);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(20f);


        //lấy chart


        mChart.setData(data);
        mChart.invalidate();
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setUsePercentValues(true);
        mChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);


        final Legend legend=mChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        legend.setFormSize(20f);
        legend.setXEntrySpace(7);
        legend.setYEntrySpace(5);
        legend.setTextColor(Color.BLACK);
        legend.setTextSize(15f);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getActivity(), ""+e.getY()+ " VND", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        */
        return view;
    }
}
