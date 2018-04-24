package com.uchin.kitabuljami;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.uchin.kitabuljami.adapters.DaftarHaditsAdapter;
import com.uchin.kitabuljami.utils.Hadits;
import com.uchin.kitabuljami.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;

public class MainTopics1 extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    public static final String ARG_ITEM_ID = "product_list";

    private final List<Hadits> haditsList = new ArrayList<>();
    private DaftarHaditsAdapter mAdapter;
    SharedPreference sharedPreference;

    private Activity activity;
    private AdapterView.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_main_topics1);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setTitle(R.string.bab1);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerHaditsAdab);

        mAdapter = new DaftarHaditsAdapter(activity, haditsList, (DaftarHaditsAdapter.DaftarHaditsAdapterListener) listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Hadits hadits = new Hadits(1, "1", "Hak-Hak Sesama Muslim", "HR.Bukhari");
        haditsList.add(hadits);

        hadits = new Hadits(2, "2", "Anjuran Melihat Kepada Yang Lebih Rendah Dalam Masalah Nikmat", "Muttafaqqun 'alaih");
        haditsList.add(hadits);

        hadits = new Hadits(3, "3", "Kebaikan Dan Dosa", "HR.Muslim");
        haditsList.add(hadits);

        hadits = new Hadits(4, "4", "Laranngan Berbisik-bisik Tanpa Melibatkan Yang Lain", "Muttafaqqun 'alaih dan Lafadznya milik Muslim");
        haditsList.add(hadits);

        hadits = new Hadits(5, "5", "Larangan Mengusir Orang Lain Dari Tempat Duduknya", "Muttafaqqun 'alaih");
        haditsList.add(hadits);

        hadits = new Hadits(6, "6", "Anjuran Menjilati Jari Tangan Setelah Makan", "Muttafaqqun 'alaih");
        haditsList.add(hadits);

        hadits = new Hadits(7, "7", "Anjuran Mengucapkan Salam", "Muttafaqqun 'alaih");
        haditsList.add(hadits);

        hadits = new Hadits(8, "8", "Ucapan Salam Dalam Rombongan", "HR.Ahmad dan Baihaqi");
        haditsList.add(hadits);

        hadits = new Hadits(9, "9", "Larangan Mendahului Salam Kepada Orang Kafir", "HR.Muslim");
        haditsList.add(hadits);

        hadits = new Hadits(10, "10", "Anjuran Mendoakan Kepada Orang Yang Bersin", "HR.Bukhari");
        haditsList.add(hadits);

        hadits = new Hadits(11, "11", "Larangan Melakukan Minum Sambil Berdiri", "HR.Muslim");
        haditsList.add(hadits);

        hadits = new Hadits(12, "12", "Adab Memakai Sandal", "Muttafaqqun 'alaih");
        haditsList.add(hadits);

        hadits = new Hadits(13, "13", "Larangan Berjalan Dengan Satu Sandal", "HR.Bukhari");
        haditsList.add(hadits);

        hadits = new Hadits(14, "14", "Larangan Mengenakan Pakaian Isbal", "HR.Bukhari");
        haditsList.add(hadits);

        hadits = new Hadits(15, "15", "Adab Makan dan Minum", "HR.Bukhari");
        haditsList.add(hadits);

        hadits = new Hadits(16, "16", "Larangan Berlebih-lebihan", "HR.Bukhari");
        haditsList.add(hadits);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Hadits product = (Hadits) parent.getItemAtPosition(position);
        Toast.makeText(activity, product.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
