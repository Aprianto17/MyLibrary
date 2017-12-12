package com.example.aprianto.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aprianto on 12/7/2017.
 */

public class Buku implements Parcelable {
    private String id_buku;
    private String judul;
    private String author;
    private String publisher;

    private String[][] data = new String[][] {
            {"bk1","Pemrograman Mobile","Mohammad Sofyan","KHARISMA Publishing"},
            {"bk2","Learning Android Aplication Testing","Paul Blundell, D.T.Milano","Packt Publishing"}
    };

    public Buku (String id_buku){
        this.id_buku = id_buku;
        this.login();
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
        this.login();
    }

    private void login() {
        for (int i = 0; i < this.data.length; i++) {
            if (this.id_buku.equals(this.data[i][0])) {
                this.judul = this.data[i][1];
                this.author = this.data[i][2];
                this.publisher = this.data[i][3];
            }

        }
    }

    public String getId_buku() {
        return id_buku;

    }



    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }



    //test

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_buku);
        dest.writeString(this.judul);
        dest.writeString(this.author);
        dest.writeString(this.publisher);
    }

    protected Buku(Parcel in) {
        this.id_buku = in.readString();
        this.judul = in.readString();
        this.author = in.readString();
        this.publisher = in.readString();
    }

    public static final Creator<Buku> CREATOR = new Creator<Buku>() {
        @Override
        public Buku createFromParcel(Parcel source) {
            return new Buku(source);
        }

        @Override
        public Buku[] newArray(int size) {
            return new Buku[size];
        }
    };
}
