package com.example.quanlychitieu.TabPage;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.quanlychitieu.Database.DatabaseLoaiChi;
import com.example.quanlychitieu.Model.ModelLoaiChi;
import com.example.quanlychitieu.R;
import com.example.quanlychitieu.ViewHolder.LoaiChiAdapter;

import java.util.ArrayList;
import java.util.List;




public class LoaiChiFragment extends Fragment {
    RecyclerView recyclerView_LoaiChi;

    FloatingActionButton btnFab;
    Button btnAdd, btnHuy;
    EditText edtName;

    DatabaseLoaiChi databaseLoaiChi;

    List<ModelLoaiChi> listdata;
    LoaiChiAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loai_chi, container, false);

        listdata=new ArrayList<>();
        recyclerView_LoaiChi =view.findViewById(R.id.recyclerview_loaichi);
        recyclerView_LoaiChi.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView_LoaiChi.setLayoutManager(layoutManager);
        btnFab=view.findViewById(R.id.fab);

        databaseLoaiChi=new DatabaseLoaiChi(getContext());

        LoadDataLoaiChi();
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDialogAdd();
            }
        });
        return view;
    }

    private void ShowDialogAdd() {
        final Dialog add_loaithu_layout=new Dialog(getContext());
        add_loaithu_layout.setTitle("Thêm Loại Thu ");
        add_loaithu_layout.setCancelable(false);

        add_loaithu_layout.setContentView(R.layout.new_item_loaithu);
        add_loaithu_layout.getWindow().setBackgroundDrawableResource(R.color.colorWhite);
        btnAdd=add_loaithu_layout.findViewById(R.id.btnAdd);
        btnHuy=add_loaithu_layout.findViewById(R.id.btnHuy);
        edtName=add_loaithu_layout.findViewById(R.id.edtName);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNew();
                add_loaithu_layout.cancel();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_loaithu_layout.cancel();
            }
        });
        add_loaithu_layout.show();
    }

    private void AddNew() {
        ModelLoaiChi modelLoaiChi =new ModelLoaiChi(edtName.getText().toString());
        long check=databaseLoaiChi.AddItem(modelLoaiChi);
        if(check>0){
            Toast.makeText(getContext(), "Thành Công", Toast.LENGTH_SHORT).show();
            LoadDataLoaiChi();
        }else {
            Toast.makeText(getContext(), "Thất Bại", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadDataLoaiChi() {
        listdata=databaseLoaiChi.getLoaiChi();
        adapter=new LoaiChiAdapter(listdata,getContext());
        recyclerView_LoaiChi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}