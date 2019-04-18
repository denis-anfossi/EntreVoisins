package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailsActivity extends AppCompatActivity {
    @BindView(R.id.activity_neighbour_details_toolbar)
    public android.support.v7.widget.Toolbar mToolbar;
    @BindView(R.id.activity_neighbour_details_toolbar_btn)
    public ImageButton mToolbarButton;
    @BindView(R.id.activity_neighbour_details_toolbar_img)
    public ImageView mNeighbourAvatar;
    @BindView(R.id.activity_neighbour_details_toolbar_txt)
    public TextView mToolbarTextView;
    @BindView(R.id.infos_card_title_txt)
    public TextView mInfosCardTitleTextView;

    private Neighbour mNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        ButterKnife.bind(this);

        getNeighbour();
        configureToolbar();
        comfigureInfosCard();
    }

    private void getNeighbour() {
        mNeighbour = getIntent().getParcelableExtra("Neighbour");
    }

    private void configureToolbar() {
        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mNeighbourAvatar);
        mToolbarTextView.setText(mNeighbour.getName());

        mToolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void comfigureInfosCard() {
        mInfosCardTitleTextView.setText(mNeighbour.getName());
    }
}
