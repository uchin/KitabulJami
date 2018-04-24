package com.uchin.kitabuljami.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uchin.kitabuljami.R;
import com.uchin.kitabuljami.utils.Hadits;

import java.util.List;

/**
 * Created by Mukhlasin on 9/7/2017.
 */

public class DaftarHaditsAdapter extends RecyclerView.Adapter<DaftarHaditsAdapter.MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Hadits item);
    }

    private List<Hadits> allHaditsList;
    private DaftarHaditsAdapterListener onClickListener;
    //private SharedPreference sharedPreference;


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView noUrutHadits, judul, status;
        ImageView bookmarkImg;
        LinearLayout recyclerViewHaditsItem;

        MyViewHolder(View itemView) {
            super(itemView);
            noUrutHadits = itemView.findViewById(R.id.noUrutHadits);
            recyclerViewHaditsItem = itemView.findViewById(R.id.haditsItem);
            judul = itemView.findViewById(R.id.judulHadits);
            status = itemView.findViewById(R.id.status);
            bookmarkImg = itemView.findViewById(R.id.bookmarkImg);

            recyclerViewHaditsItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.recyclerViewHaditsOnClick(v, getAdapterPosition());
                }
            });

            bookmarkImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.iconBookmarkOnClick(v, getAdapterPosition());
                }
            });

            status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.statusTextViewOnClick(v, getAdapterPosition());
                }
            });
        }
    }

    public DaftarHaditsAdapter(Context context, List<Hadits> haditsList, DaftarHaditsAdapterListener listener) {
        this.allHaditsList = haditsList;
        this.onClickListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hadits_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Hadits hadits = allHaditsList.get(position);
        holder.noUrutHadits.setText(hadits.getNoUrutHadits());
        holder.judul.setText(hadits.getJudul());
        holder.status.setText(hadits.getStatus());
    }

    public interface DaftarHaditsAdapterListener {
        void recyclerViewHaditsOnClick(View v, int position);
        void iconBookmarkOnClick(View v, int position);
        void statusTextViewOnClick(View v, int position);
    }

    @Override
    public int getItemCount() {
        return allHaditsList.size();
    }
}
