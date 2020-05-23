package com.aa183.setiadi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aa183.setiadi.InputActivity;
import com.aa183.setiadi.R;
import com.aa183.setiadi.TampilActivity;
import com.aa183.setiadi.model.Buku;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {

    private List<Buku> dataBuku;
    private Context context;

    public BukuAdapter(List<Buku> dataBuku, Context context) {
        this.dataBuku = dataBuku;
        this.context = context;
    }

    @NonNull
    @Override
    public BukuAdapter.BukuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_buku, parent, false);
        return new BukuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BukuAdapter.BukuViewHolder holder, int position) {
        Buku tempBuku = dataBuku.get(position);

        holder.id = tempBuku.getId();
        holder.judul = tempBuku.getJudul();
        holder.jenis = tempBuku.getJenis();
        holder.tvJudul.setText(holder.judul);
        holder.tvJenis.setText(holder.jenis);
        holder.halaman = tempBuku.getHalaman();
        holder.bahasaBuku = tempBuku.getBahasa();
        holder.penulisBuku = tempBuku.getPenulis();
        holder.tahun = tempBuku.getTahun();

        String imgLocation = tempBuku.getGambar();

        if (!imgLocation.equals(null)) {
            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imgBuku);
        }
        holder.imgBuku.setContentDescription(tempBuku.getGambar());
    }

    @Override
    public int getItemCount() {
        return dataBuku.size();
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        private TextView tvJudul, tvJenis;
        private ImageView imgBuku;
        private int id;
        private String judul, jenis, bahasaBuku, penulisBuku, halaman, tahun;

        public BukuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvJenis = itemView.findViewById(R.id.tv_jenis);
            imgBuku = itemView.findViewById(R.id.iv_buku);

            // onclick
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void onClick(View v) {
            Intent openDisplay = new Intent(context, TampilActivity.class);
            openDisplay.putExtra("JUDUL", judul);
            openDisplay.putExtra("JENIS", jenis);
            openDisplay.putExtra("GAMBAR", imgBuku.getContentDescription());
            openDisplay.putExtra("HALAMAN", halaman);
            openDisplay.putExtra("BAHASA", bahasaBuku);
            openDisplay.putExtra("PENULIS", penulisBuku);
            openDisplay.putExtra("TAHUN", tahun);
            itemView.getContext().startActivity(openDisplay);
        }

        public boolean onLongClick(View v) {
            Intent openInput = new Intent(context, InputActivity.class);
            openInput.putExtra("OPERATION", "update");
            openInput.putExtra("ID", id);
            openInput.putExtra("JUDUL", tvJudul.getText());
            openInput.putExtra("JENIS", tvJenis.getText());
            openInput.putExtra("GAMBAR", imgBuku.getContentDescription());
            openInput.putExtra("HALAMAN", halaman);
            openInput.putExtra("BAHASA", bahasaBuku);
            openInput.putExtra("PENULIS", penulisBuku);
            openInput.putExtra("TAHUN", tahun);
            itemView.getContext().startActivity(openInput);
            return true;
        }
    }
}
