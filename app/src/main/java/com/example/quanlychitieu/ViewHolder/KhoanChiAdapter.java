package com.example.quanlychitieu.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quanlychitieu.Model.ModelKhoanChi;
import com.example.quanlychitieu.R;

import java.util.ArrayList;
import java.util.List;


class KhoanChiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView txt_KhoangThu,txt_SoTien,txtNgay;
    public List<ModelKhoanChi> list=new ArrayList<>();
    public Context context;

    public KhoanChiViewHolder(View itemView,Context context,List<ModelKhoanChi> list) {
        super(itemView);
        this.list=list;
        this.context=context;
        txt_KhoangThu=itemView.findViewById(R.id.txtLoaiThu);
        txt_SoTien=itemView.findViewById(R.id.txtSoTien);
        txtNgay=itemView.findViewById(R.id.txtNgay);
        itemView.setOnClickListener(this);
        //itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiViewHolder>{

    private List<ModelKhoanChi> listData= new ArrayList<>();
    private Context context;

    public KhoanChiAdapter(List<ModelKhoanChi> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }


    @Override
    public KhoanChiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.item_khoan_chi,parent,false);
        return new KhoanChiViewHolder(itemView,context,listData);
    }
    @Override
    public void onBindViewHolder(KhoanChiViewHolder holder, int position) {
        holder.txt_KhoangThu.setText(listData.get(position).getLoaiChi());

        holder.txt_SoTien.setText(listData.get(position).getSoTienChi() + " đ");

        holder.txtNgay.setText(listData.get(position).getNgayChi());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
