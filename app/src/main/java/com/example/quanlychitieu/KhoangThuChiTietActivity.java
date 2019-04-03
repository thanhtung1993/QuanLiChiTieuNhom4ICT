package com.example.quanlychitieu;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class KhoangThuChiTietActivity extends AppCompatActivity {

    TextView txtngay,txttaikhoan,txtsotien,txtloaithu,txtmota;


    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoang_thu_chi_tiet);

        txtngay=findViewById(R.id.txtngay);
        txttaikhoan=findViewById(R.id.txttaikhoan);
        txtsotien=findViewById(R.id.txtsotien);
        txtloaithu=findViewById(R.id.txtloaithu);
        txtmota=findViewById(R.id.txtmota);
        String Nameloaithu=getIntent().getStringExtra("loaithu");
        collapsingToolbarLayout=findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        collapsingToolbarLayout.setTitle(Nameloaithu);

        toolbar=findViewById(R.id.toolbarorder);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() !=null)
        {
            Drawable drawable= ResourcesCompat.getDrawable(this.getResources(), R.drawable.ic_arrow_back_black_24dp, null);

            //custom color
            drawable.setColorFilter(ResourcesCompat.getColor(this.getResources(), R.color.colorAccent, null), PorterDuff.Mode.SRC_IN);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(drawable);

        }
        txtngay.setText(getIntent().getStringExtra("ngay"));
        txttaikhoan.setText(getIntent().getStringExtra("taikhoan"));

        txtsotien.setText(getIntent().getStringExtra("sotien"));

        txtloaithu.setText(Nameloaithu);
        txtmota.setText(getIntent().getStringExtra("mota"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
