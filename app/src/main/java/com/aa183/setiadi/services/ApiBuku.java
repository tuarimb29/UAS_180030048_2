package com.aa183.setiadi.services;

import com.aa183.setiadi.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBuku {

    @FormUrlEncoded@POST("create.php")
    Call<ResponseData> addData(
            @Field("judul") String judul,
            @Field("gambar") String gambar,
            @Field("jenis") String jenis,
            @Field("halaman") String halaman,
            @Field("bahasa") String bahasa,
            @Field("penulis") String penulis,
            @Field("tahun") String tahun
    );

    @FormUrlEncoded@POST("update.php")
    Call<ResponseData> editData(
            @Field("id") String id,
            @Field("judul") String judul,
            @Field("gambar") String gambar,
            @Field("jenis") String jenis,
            @Field("halaman") String halaman,
            @Field("bahasa") String bahasa,
            @Field("penulis") String penulis,
            @Field("tahun") String tahun
    );

    @FormUrlEncoded@POST("delete.php")
    Call<ResponseData> deleteData(
            @Field("id") String id
    );

    @FormUrlEncoded@POST("search.php")
    Call<ResponseData> searchData(
            @Field("search") String keyword
    );

    @GET("read.php")
    Call<ResponseData> getData();
}
