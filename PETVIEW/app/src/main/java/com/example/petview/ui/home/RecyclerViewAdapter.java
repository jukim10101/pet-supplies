package com.example.petview.ui.home;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.petview.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<HomeRankingData> mHomeItems;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<HomeRankingData> homeItems) {
        this.mHomeItems = homeItems;
    }

    public RecyclerViewAdapter(Context context, ArrayList<HomeRankingData> homeItems) {
        this.mHomeItems = homeItems;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemName.setText(mHomeItems.get(position).getName());
        holder.itemPrice.setText(mHomeItems.get(position).getPrice());
        holder.itemRanking.setText(mHomeItems.get(position).getRank());
        holder.itemImage.setImageResource(mHomeItems.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public TextView itemPrice;
        public TextView itemRanking;
        public ImageView itemImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemName = (TextView)itemView.findViewById(R.id.home_ranking_name);
            itemPrice = (TextView)itemView.findViewById(R.id.home_ranking_price);
            itemRanking = (TextView)itemView.findViewById(R.id.home_ranking_rank);
            itemImage = (ImageView)itemView.findViewById(R.id.home_ranking_image);
        }
    }
}
