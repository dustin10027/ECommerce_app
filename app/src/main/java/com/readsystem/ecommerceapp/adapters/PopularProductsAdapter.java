package com.readsystem.ecommerceapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.readsystem.ecommerceapp.R;
import com.readsystem.ecommerceapp.activities.DetailedActivity;
import com.readsystem.ecommerceapp.models.PopularProductsModel;

import java.util.List;

public class PopularProductsAdapter extends RecyclerView.Adapter<PopularProductsAdapter.ViewHolder> {


    private Context context;
    private List<PopularProductsModel> popularProductsModelList;

    public PopularProductsAdapter(Context context, List<PopularProductsModel> popularProductsModelList) {
        this.context = context;
        this.popularProductsModelList = popularProductsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(popularProductsModelList.get(position).getImg_url()).into(holder.imageView);
        holder.nombre.setText(popularProductsModelList.get(position).getNombre());
        holder.precio.setText(String.valueOf(popularProductsModelList.get(position).getPrecio()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, DetailedActivity.class);
                intent.putExtra("detalle",popularProductsModelList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return popularProductsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nombre,precio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.all_img);
            nombre= itemView.findViewById(R.id.all_product_name);
            precio= itemView.findViewById(R.id.all_price);
        }
    }
}
