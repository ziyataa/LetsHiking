package com.ziyata.letshiking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {
    String[] namaGunung, isiGunung;
    int[] gambarGunung;

    @BindView(R.id.myToolbar)
    Toolbar myToolbar;
    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        namaGunung = getResources().getStringArray(R.array.nama_gunung);
        isiGunung = getResources().getStringArray(R.array.isi_gunung);
        gambarGunung = new int[]{R.drawable.gede, R.drawable.merapi, R.drawable.merbabu, R.drawable.rinjani, R.drawable.semeru, R.drawable.sumbing};

        AdapterGunung adapterGunung = new AdapterGunung(this, namaGunung, isiGunung, gambarGunung);

        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleView.setAdapter(adapterGunung);
    }


        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.About:
                    Intent pindah = new Intent(this, About.class);
                    startActivity(pindah);
                    break;
                case R.id.Profile:
                    pindah = new Intent(this, Profile.class);
                    startActivity(pindah);
            }
            return super.onOptionsItemSelected(item);
        }
    }

