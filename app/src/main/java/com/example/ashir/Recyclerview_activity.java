package com.example.ashir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class Recyclerview_activity extends AppCompatActivity {

    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<Model_class> ModelclassList = new ArrayList<>();
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is user item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 2nd user item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 3rd user item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 4th user item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 5th user item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 6thuser item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 7thuser item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 8thuser item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 9thuser item"));
        ModelclassList.add(new Model_class(R.drawable.ic_launcher_background, "", "hellow this is 10thuser item"));
        adapter1 Adapter = new adapter1(ModelclassList, this);
        recyclerView.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();



    }
}