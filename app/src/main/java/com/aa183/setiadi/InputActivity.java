package com.aa183.setiadi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.aa183.setiadi.model.ResponseData;
import com.aa183.setiadi.services.ApiBuku;
import com.aa183.setiadi.services.ApiClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ProgressDialog progressDialog;
    private EditText editJudul, editHalaman, editBahasa, editPenulis, editTahun;
    private Button btnSave;
    private ImageView imgBuku;
    private String imgLocation, jenis;
    private Spinner spinnerJenis;
    private boolean updateOperation = false;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        progressDialog = new ProgressDialog(InputActivity.this);

        editJudul = findViewById(R.id.edit_judul);
        editHalaman = findViewById(R.id.edit_jumlah);
        editBahasa = findViewById(R.id.edit_bahasa);
        editPenulis = findViewById(R.id.edit_penulis);
        editTahun = findViewById(R.id.edit_tahun);
        imgBuku = findViewById(R.id.image_buku);
        btnSave = findViewById(R.id.btn_simpan);
        spinnerJenis = findViewById(R.id.spinner_jenis);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.jenis, R.layout.spinner_item
        );
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerJenis.setAdapter(adapter);
        spinnerJenis.setOnItemSelectedListener(this);

        Intent receiveData = getIntent();
        Bundle data = receiveData.getExtras();

        if (data.getString("OPERATION").equals("insert")) {
            updateOperation = false;
        } else {
            updateOperation = true;
            id = data.getInt("ID");
            imgLocation = data.getString("GAMBAR");
            editJudul.setText(data.getString("JUDUL"));
            editHalaman.setText(data.getString("HALAMAN"));
            editBahasa.setText(data.getString("BAHASA"));
            editPenulis.setText(data.getString("PENULIS"));
            editTahun.setText(data.getString("TAHUN"));
            jenis = data.getString("JENIS");

            switch (jenis) {
                case "Petualangan":
                    spinnerJenis.setSelection(0);
                    break;
                case "Musik":
                    spinnerJenis.setSelection(1);
                    break;
                case "Multimedia":
                    spinnerJenis.setSelection(2);
                    break;
                case "Jaringan":
                    spinnerJenis.setSelection(3);
                    break;
                case "Motivasi":
                    spinnerJenis.setSelection(4);
                    break;
            }

            if (imgLocation != null) {
                Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
                builder.build().load(imgLocation)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(imgBuku);
            }
            imgBuku.setContentDescription(imgLocation);
        }
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String txt = parent.getItemAtPosition(position).toString();
        switch (txt) {
            case "Petualangan":
                this.jenis = txt;
                this.imgLocation = ApiClient.IMG_URL + "bluebook.png";
                break;
            case "Musik":
                this.jenis = txt;
                this.imgLocation = ApiClient.IMG_URL + "redbook.png";
                break;
            case "Multimedia":
                this.jenis = txt;
                this.imgLocation = ApiClient.IMG_URL + "orangebook.png";
                break;
            case "Jaringan":
                this.jenis = txt;
                this.imgLocation = ApiClient.IMG_URL + "greenbook.png";
                break;
            case "Motivasi":
                this.jenis = txt;
                this.imgLocation = ApiClient.IMG_URL + "pinkbook.png";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item_menu_delete) {
            deleteData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.item_menu_delete);
        if (updateOperation == true) {
            item.setEnabled(true);
            item.getIcon().setAlpha(255);
        } else {
            item.setEnabled(false);
            item.getIcon().setAlpha(130);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private void saveData() {
        progressDialog.setMessage("Saving...");
        progressDialog.show();

        String judul = editJudul.getText().toString();
        String halaman = editHalaman.getText().toString();
        String bahasa = editBahasa.getText().toString();
        String penulis = editPenulis.getText().toString();
        String tahun = editTahun.getText().toString();

        if (!(judul.equals("") && jenis .equals(""))){
            ApiBuku api = ApiClient.getRetrofitInstance().create(ApiBuku.class);
            Call<ResponseData> call;

            if (updateOperation == false) {
                call = api.addData(judul, imgLocation, jenis, halaman, bahasa, penulis, tahun);
            } else {
                call = api.editData(String.valueOf(id), judul, imgLocation, jenis, halaman, bahasa, penulis, tahun);
                updateOperation = false;
            }
            call.enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                    String value = response.body().getValue();
                    String message = response.body().getMessage();

                    progressDialog.dismiss();

                    if (value.equals("1")) {
                        Toast.makeText(InputActivity.this, "SUKSES: " + message, Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(InputActivity.this, "GAGAL: " + message, Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(InputActivity.this, "Gagal menghubungi server...", Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                    Log.d("Input Data Error", t.toString());
                }
            });
        } else {
            Toast.makeText(this, "Data Belum Lengkap", Toast.LENGTH_LONG).show();
        }
    }

    private void deleteData(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Hapus Data");
        builder.setMessage("Apakah anda yakin ingin menghapus data?")
                .setCancelable(false)
                .setPositiveButton("Hapus", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog.setMessage("Deleting...");
                        progressDialog.show();
                        ApiBuku api = ApiClient.getRetrofitInstance().create(ApiBuku.class);
                        Call<ResponseData> call = api.deleteData(String.valueOf(id));
                        call.enqueue(new Callback<ResponseData>() {

                            @Override
                            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                String value = response.body().getValue();
                                String message = response.body().getMessage();
                                progressDialog.dismiss();
                                if(value.equals("1")) {
                                    Toast.makeText(InputActivity.this, "SUKSES: " + message, Toast.LENGTH_LONG).show();
                                } else{
                                    Toast.makeText(InputActivity.this, "GAGAL: " + message, Toast.LENGTH_LONG).show();
                                }
                                finish();
                            }

                            @Override
                            public void onFailure(Call<ResponseData> call, Throwable t) {
                                progressDialog.dismiss();
                                Toast.makeText(InputActivity.this, "Gagal menghubungi server...", Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                                Log.d("Delete Data Error", t.toString());
                            }
                        });
                    }
                }).setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
