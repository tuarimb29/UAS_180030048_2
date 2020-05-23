package com.aa183.setiadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class TampilActivity extends AppCompatActivity {

    private TextView tvJudul, tvJenis, tvHalaman, tvBahasa, tvPenulis, tvTahun;
    private ImageView ivGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        tvJudul = findViewById(R.id.judul_display);
        tvJenis = findViewById(R.id.jenis_display);
        tvHalaman = findViewById(R.id.jumlah_display);
        tvBahasa = findViewById(R.id.bahasa_display);
        tvPenulis = findViewById(R.id.penulis_display);
        tvTahun = findViewById(R.id.tahun_display);
        ivGambar = findViewById(R.id.buku_image_display);

        Intent receiveData = getIntent();
        Bundle data = receiveData.getExtras();
        tvJudul.setText(data.getString("JUDUL"));
        tvJenis.setText(data.getString("JENIS"));
        tvHalaman.setText(data.getString("HALAMAN"));
        tvBahasa.setText(data.getString("BAHASA"));
        tvPenulis.setText(data.getString("PENULIS"));
        tvTahun.setText(data.getString("TAHUN"));
        String imgLocation = data.getString("GAMBAR");

        if (!imgLocation.equals(null)) {
            Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
            builder.downloader(new OkHttp3Downloader(getApplicationContext()));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(ivGambar);
        }
        ivGambar.setContentDescription(imgLocation);
    }
}
