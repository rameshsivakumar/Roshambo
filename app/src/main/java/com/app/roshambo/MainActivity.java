package com.app.roshambo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.databinding.DataBindingUtil;
import com.app.roshambo.databinding.ActivityMainBinding;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements MainContract {

    int[] images = new int[]{
            R.mipmap.rock,
            R.mipmap.paper,
            R.mipmap.scissors
    };
    int userinput = 0;

    ActivityMainBinding binding;
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new MainActivityPresenter();
        presenter.setView(this);
        binding.setPresenter(presenter);
    }

    public void updateUI(int input, int output, int userSelected) {
        userinput = userSelected;
        Picasso.get().load(input).into(binding.ivInput);
        Picasso.get().load(images[output]).into(binding.ivOutput);
        checkresult(output);
    }

    private void checkresult(int imageId) {
        if (userinput == 0 && imageId == 0) {     //User choose Rock,Computer choose Rock
            showresult(2);
        } else if (userinput == 0 && imageId == 1) { //User choose Rock,Computer choose Paper
            showresult(0);
        } else if (userinput == 0 && imageId == 2) { //User choose Rock,Computer choose Scissors
            showresult(1);
        } else if (userinput == 1 && imageId == 0) { //User choose Paper,Computer choose Rock
            showresult(1);
        } else if (userinput == 1 && imageId == 1) { //User choose Paper,Computer choose Paper
            showresult(2);
        } else if (userinput == 1 && imageId == 2) { //User choose Paper,Computer choose Scissors
            showresult(0);
        } else if (userinput == 2 && imageId == 0) {//User choose Scissors,Computer choose Rock
            showresult(0);
        } else if (userinput == 2 && imageId == 1) { //User choose Scissors,Computer choose Paper
            showresult(1);
        } else if (userinput == 2 && imageId == 2) { //User choose Scissors,Computer choose Scissors
            showresult(2);
        }
    }

    private void showresult(int result) {
        if (result == 0) {
            Toast.makeText(getApplicationContext(), R.string.lost_text, Toast.LENGTH_SHORT).show();
        } else if (result == 1)
            Toast.makeText(getApplicationContext(), R.string.won_text, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), R.string.draw_text, Toast.LENGTH_SHORT).show();
    }
}
