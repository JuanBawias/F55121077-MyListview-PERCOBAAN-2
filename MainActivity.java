package com.example.F55121077;

import static android.os.Looper.prepare;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private com.example.F55121077.HeroAdapter adapter;
    private ArrayList<hero> heroes;

    private String[] dataname = {"Ahmad Dahlan", "Ahmad Yani", "Bung Tomo", "Gatot Subroto", "Ki Hajar Dewantara", "Mohammad Hatta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new com.example.F55121077.HeroAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        additem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
                if (Position == 0) {
                    startActivity(new Intent(MainActivity.this, ListView.class));
                }
            }

            private void addItem() {
                heroes = new ArrayList<>();
                for (int i = 0; i < dataName.length; i++) {
                    hero hero = new hero();
                    hero.setPhoto(dataPhoto.getResourceId(i, -1));
                    hero.setName(dataName[i]);
                    hero.setDescription(dataDescription[i]);
                    heroes.add(hero);
                }
                adapter.setHeroes(heroes);
            }

            private void prepare() {
                dataName = getResources().getStringArray(R.array.data_name);
                dataDescription = getResources().getStringArray(R.array.data_description);
                dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
            }


        });

    }

    private void additem() {
    }
}