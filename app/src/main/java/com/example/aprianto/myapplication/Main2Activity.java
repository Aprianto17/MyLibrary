package com.example.aprianto.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private User user;
    private Pinjaman pinjaman;
    private TextView tv_nama,tv_anggota,tv_email,tv_author,tv_Publisher,tv_TglPinjam,tv_TglKembali,tv_judul,tv_tlp,tglkembali,tglpinjam;
    private Button tb_logout;
    private String id = "id";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_nama = (TextView) findViewById(R.id.tv_name);
        tv_anggota = (TextView) findViewById(R.id.tv_anggota);
        tv_author = (TextView) findViewById(R.id.tv_author);
        tv_Publisher = (TextView) findViewById(R.id.tv_Publisher);
        tv_TglPinjam = (TextView) findViewById(R.id.tv_TglPinjam);
        tv_TglKembali = (TextView) findViewById(R.id.tv_TglKembali);
        tglkembali = (TextView) findViewById(R.id.tglkembali);
        tglpinjam = (TextView) findViewById(R.id.tglpinjam);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_judul = (TextView) findViewById(R.id.tv_judul);
        tv_tlp = (TextView) findViewById(R.id.tv_tlp);
        tb_logout = (Button) findViewById(R.id.tb_logout);

        tb_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                Main2Activity.this.startActivity(intent);
                finish();

            }
        });

        Bundle extras = getIntent().getExtras();
        id = extras.getString(id);
        tv_email.setText(id);
        String id_m = tv_email.getText().toString().trim();


        if( !TextUtils.isEmpty( id_m )) {
            user = new User(id_m);
            tv_nama.setText(user.getNamalengkap());
            tv_anggota.setText(user.getIdmember());
            tv_tlp.setText(user.getTlp());

        }
        String id_me = tv_anggota.getText().toString().trim();
        pinjaman = new Pinjaman(id_me);
        String ids = pinjaman.getId();

            if(ids == "1") {
                tv_judul.setText(pinjaman.getBuku().getJudul());
                tv_author.setText(pinjaman.getBuku().getAuthor());
                tv_Publisher.setText(pinjaman.getBuku().getPublisher());
                tv_TglPinjam.setText(pinjaman.getTanggalPinjam());
                tv_TglKembali.setText(pinjaman.getTanggalKembali());
            } else {
                tv_judul.setText("Tidak Ada Pinjaman");
                tv_author.setText(" ");
                tglpinjam.setText(" ");
                tglkembali.setText(" ");
                tv_Publisher.setText(" ");
                tv_TglPinjam.setText(" ");
                tv_TglKembali.setText(" ");
            }

    }
}
