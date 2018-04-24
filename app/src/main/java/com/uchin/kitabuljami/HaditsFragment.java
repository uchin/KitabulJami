package com.uchin.kitabuljami;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uchin.kitabuljami.adapters.DaftarHaditsAdapter;
import com.uchin.kitabuljami.utils.Hadits;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mukhlasin on 7/18/2017.
 */

public class HaditsFragment extends Fragment {

    List<Hadits> haditsList = new ArrayList<>();
    DaftarHaditsAdapter.OnItemClickListener listener;

    private Context context;

    //SharedPreference sharedPreference;

    RecyclerView recyclerView;
    DaftarHaditsAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = getActivity();
        //sharedPreference = new SharedPreference();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hadits_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        final List<Hadits> haditsList = new ArrayList<>();

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

        //super.onViewCreated(view, savedInstanceState);
        final DaftarHaditsAdapter itemsAdapter = new DaftarHaditsAdapter(context,haditsList, new DaftarHaditsAdapter.DaftarHaditsAdapterListener(){

            @Override
            public void recyclerViewHaditsOnClick(View v, int position) {
                //gotoUserProfile(followersList.get(position).getID());
                Log.e("plz", "recyclerViewHaditsOnClick at position " + position);
                Toast.makeText(getActivity(), "recyclerViewHaditsOnClick " + position ,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HaditsDetail.class);
                startActivity(intent);
            }

            @Override
            public void iconBookmarkOnClick(View v, int position) {
                Log.e("plz", "iconBookmarkOnClickat position " + position);
                Toast.makeText(getActivity(), "iconBookmarkOnClick " + position ,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void statusTextViewOnClick(View v, int position) {
                Log.e("plz", "statusTextViewOnClick at position " + position);
                Toast.makeText(getActivity(), "statusTextViewOnClick " + position ,
                        Toast.LENGTH_SHORT).show();
            }
        });
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerHadits);
        recyclerView.setLayoutManager(new LinearLayoutManager(HaditsFragment.this.getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(HaditsFragment.this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(itemsAdapter);



        super.onViewCreated(view, savedInstanceState);



    }
}
