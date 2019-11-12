package com.lp3i.fatah.utsmyapplication;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    //jika tulisan berwarna merah. tekan alt + enter (untuk import)

    //persiapan variable objek yg ada pada XML
    EditText etNamaDepan, etNamaBelakang, etAlamat, etTelepon;
    Spinner spJenisKelamin;
    CheckBox cbSMKdwidaya, cbSMUdonbosco, cbSMUmerahputih, cbSMUsutarmadja;
    RadioGroup rgLulusan;
    Button btSimpan;

    /*
    RadioButton rb_sma, rb_smk dan rb_ma tak perli didefinisikan karena sudah termasuk dalam "radio group"
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaDepan = (EditText) findViewById(R.id.et_namadepan);
        etNamaBelakang = (EditText) findViewById(R.id.et_namabelakang);
        etAlamat = (EditText) findViewById(R.id.et_alamat);
        etTelepon = (EditText) findViewById(R.id.et_telepon);
        spJenisKelamin = (Spinner) findViewById(R.id.sp_jeniskelamin);
        cbSMKdwidaya = (CheckBox) findViewById(R.id.cb_SMKdwidaya);
        cbSMUdonbosco = (CheckBox) findViewById(R.id.cb_SMUdonbosco);
        cbSMUmerahputih = (CheckBox) findViewById(R.id.cb_SMUmerahputih);
        cbSMUsutarmadja = (CheckBox) findViewById(R.id.cb_SMUsutarmadja);
        rgLulusan = (RadioGroup) findViewById(R.id.rg_lulusan);
        btSimpan = (Button) findViewById(R.id.bt_simpan);

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(), "Hai " + etNamaDepan.getText().toString(),
                        Toast.LENGTH_LONG).show();

                int selected = rgLulusan.getCheckedRadioButtonId();
                final RadioButton rbLulus = (RadioButton) findViewById(selected);

                Log.d("test",
                        etAlamat.getText().toString() + ""
                                + spJenisKelamin.getSelectedItem().toString() + ""
                                + rbLulus.getText().toString());

            }
        });

        btNotifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext(), "notify_001");
                Intent ii = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, ii, 0);

                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.setBigContentTitle("Aplikasi buatanku");
                bigText.setSummaryText("Ini adalah notifikasi dariku");

                mBuilder.setContentIntent(pendingIntent);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
                mBuilder.setContentTitle("Aplikasi buatanku");
                mBuilder.setContentText("Notifikasi ini menggunakan versi terbaru");
                mBuilder.setPriority(Notification.PRIORITY_MAX);
                mBuilder.setStyle(bigText);
                mBuilder.setDefaults(Notification.DEFAULT_SOUND); //suara
                mBuilder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000}); //getar

                NotificationManager mNotificationManager =
                        (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("notify_001",
                            "Channel human readable title",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    mNotificationManager.createNotificationChannel(channel);
                }

                mNotificationManager.notify(0, mBuilder.build());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_alert:
                btNotifikasi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(getApplicationContext(), "notify_001");
                        Intent ii = new Intent(getApplicationContext(), MainActivity.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, ii, 0);

                        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                        bigText.setBigContentTitle("Aplikasi buatanku");
                        bigText.setSummaryText("Ini adalah notifikasi dariku");

                        mBuilder.setContentIntent(pendingIntent);
                        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
                        mBuilder.setContentTitle("Aplikasi buatanku");
                        mBuilder.setContentText("Notifikasi ini menggunakan versi terbaru");
                        mBuilder.setPriority(Notification.PRIORITY_MAX);
                        mBuilder.setStyle(bigText);
                        mBuilder.setDefaults(Notification.DEFAULT_SOUND); //suara
                        mBuilder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000}); //getar

                        NotificationManager mNotificationManager =
                                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel("notify_001",
                                    "Channel human readable title",
                                    NotificationManager.IMPORTANCE_DEFAULT);
                            mNotificationManager.createNotificationChannel(channel);
                        }

                        mNotificationManager.notify(0, mBuilder.build());
                    }


                return true
                });

    }
}