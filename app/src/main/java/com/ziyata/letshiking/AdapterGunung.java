package com.ziyata.letshiking;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterGunung extends RecyclerView.Adapter<AdapterGunung.ViewHolder> {
    Context context;
    String[] namaGunung,isiGunung;
    int[] gambarGunung;

    public AdapterGunung(Context context, String[] namaGunung, String[] isiGunung, int[] gambarGunung) {
        this.context = context;
        this.namaGunung = namaGunung;
        this.isiGunung = isiGunung;
        this.gambarGunung = gambarGunung;
    }

    @NonNull
    @Override
    public AdapterGunung.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_gunung,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGunung.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaGunung[i]);
        Glide.with(context).load(gambarGunung[i]).into(viewHolder.imgGambarGunung);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailGunungActivity.class);
                intent.putExtra("ng",namaGunung[i]);
                intent.putExtra("ig",isiGunung[i]);
                intent.putExtra("gg",gambarGunung[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarGunung.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama;
        ImageView imgGambarGunung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtListTitle);
            imgGambarGunung = itemView.findViewById(R.id.imgList);
        }
    }
}
