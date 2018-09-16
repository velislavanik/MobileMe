package com.example.velis.presentation;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    String title1, title2, title3;

    /**
     * @param savedInstanceState of type Bundle
     */

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Button mBtnSuspect;

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title1 = getResources().getString(R.string.welcome);
        title2 = getResources().getString(R.string.presentation);
        title3 = getResources().getString(R.string.motivation);
        mBtnSuspect = findViewById(R.id.btn);
        mBtnSuspect.setText(getResources().getString(R.string.view_more));

        View.OnClickListener buttonListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() == 0) {

                    pager.setCurrentItem(pager.getCurrentItem() + 1, true);
                } else
                    pager.setCurrentItem(pager.getCurrentItem() + 1, true);
            }
        };
        mBtnSuspect.setOnClickListener(buttonListener);


        pager = findViewById(R.id.pager);

        pager.setAdapter(new MyPagerAdapter(getApplicationContext()));
        setActionBar();

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    setTitle(title2);
                    mBtnSuspect.setVisibility(View.VISIBLE);
                    mBtnSuspect.setText(getResources().getString(R.string.to_motivation));
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                } else if (position == 2) {
                    setTitle(title3);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    mBtnSuspect.setVisibility(View.INVISIBLE);
                } else {
                    setTitle(title1);
                    mBtnSuspect.setVisibility(View.VISIBLE);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    mBtnSuspect.setText(getResources().getString(R.string.view_more));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    public void setActionBar() {
        if (pager.getCurrentItem() == 0) {
            setTitle(title1);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        } else if (pager.getCurrentItem() == 1) {
            setTitle(title2);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        } else {
            setTitle(title3);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * This methos is called on back button press
     */
    @Override
    public void onBackPressed() {

        if (pager.getCurrentItem() != 0) {
            pager.setCurrentItem(pager.getCurrentItem() - 1, true);
            setActionBar();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
