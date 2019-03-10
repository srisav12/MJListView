package com.example.mjlistview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mjlistview.Adapter.SongsListAdapter;
import com.example.mjlistview.Models.Song;
import com.example.mjlistview.Models.SongList;
import com.example.mjlistview.Utils.ConnectivityHelper;
import com.example.mjlistview.Utils.GetSongsDataService;
import com.example.mjlistview.Utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        if (ConnectivityHelper.isConnectedToNetwork(this)) {
            loadSongsInfo();

        } else {
            showConnectivityDialog(this);

        }

    }


    //load the data from the api into the listView

    private void loadSongsInfo() {
        GetSongsDataService service = RetrofitClient.getRetrofitInstance().create(GetSongsDataService.class);

        Call<SongList> call = service.getAllUsers();

        call.enqueue(new Callback<SongList>() {
            @Override
            public void onResponse(Call<SongList> call, final Response<SongList> response) {
                final List<Song> songs = response.body().getSongDetails();
                listView.setAdapter(new SongsListAdapter(MainActivity.this, songs));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(MainActivity.this, SongDetail.class);
                        intent.putExtra("data", songs.get(i));
                        startActivity(intent);

                    }
                });

            }

            @Override
            public void onFailure(Call<SongList> call, Throwable t) {
                Log.e("failure", "error");
                t.printStackTrace();

            }
        });
    }


   // show alertDialog in case of no internet
    public void showConnectivityDialog(Context context) {
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(
                context).create();

        alertDialog.setTitle("Oops!");
        alertDialog.setMessage("Please check your internet connection.");
        alertDialog.setCancelable(false);

        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.show();
    }
}
