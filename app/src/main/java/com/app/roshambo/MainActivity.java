package com.app.roshambo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.databinding.DataBindingUtil;
import com.app.roshambo.databinding.ActivityMainBinding;

import com.app.roshambo.utils.RoshamboUtils;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements MainContract {

    int[] images = new int[]{
            R.mipmap.rock,
            R.mipmap.paper,
            R.mipmap.scissors
    };

    private ActivityMainBinding binding;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new MainActivityPresenter();
        presenter.setView(this);
        binding.setPresenter(presenter);
    }

    public void updateUI(int input, int output, int result) {
        Picasso.get().load(images[input]).into(binding.ivInput);
        Picasso.get().load(images[output]).into(binding.ivOutput);
        showresult(result);
    }

    private void showresult(int result) {
        if (result == RoshamboUtils.RESULT_LOST) {
            Toast.makeText(getApplicationContext(), R.string.lost_text, Toast.LENGTH_SHORT).show();
        } else if (result == RoshamboUtils.RESULT_WON)
            Toast.makeText(getApplicationContext(), R.string.won_text, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), R.string.draw_text, Toast.LENGTH_SHORT).show();
    }
}
