package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class NeighbourDetailsActivity extends AppCompatActivity {
    private Neighbour mNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);

        getNeighbour();
    }

    private void getNeighbour() {
        mNeighbour = getIntent().getParcelableExtra("Neighbour");
    }
}
