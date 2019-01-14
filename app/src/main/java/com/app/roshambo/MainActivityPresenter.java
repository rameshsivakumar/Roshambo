package com.app.roshambo;

import android.view.View;

import com.app.roshambo.utils.RoshamboUtils;

public class MainActivityPresenter {

    MainContract view;

    public void setView(MainContract mainview) {
        view = mainview;
    }


    public void onClick(View v) {
        int id = v.getId();
        int userSelected = 0;
        int output = RoshamboUtils.selectRandomImageId(3);
        switch (id) {
            case R.id.btn_rock:
                userSelected = 0;
                view.updateUI(R.mipmap.rock, output, userSelected);
                break;
            case R.id.btn_paper:
                userSelected = 1;
                view.updateUI(R.mipmap.paper, output, userSelected);
                break;
            case R.id.btn_scissors:
                userSelected = 2;
                view.updateUI(R.mipmap.scissors, output, userSelected);
                break;
        }
    }


}
