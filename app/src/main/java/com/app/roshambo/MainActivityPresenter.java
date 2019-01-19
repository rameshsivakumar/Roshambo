package com.app.roshambo;

import android.view.View;

import com.app.roshambo.utils.RoshamboUtils;

public class MainActivityPresenter {

    private MainContract view;

    public void setView(MainContract mainview) {
        view = mainview;
    }

    public void onClick(View v) {
        int id = v.getId();
        int input = 0;
        switch (id) {
            case R.id.btn_rock:
                input = 0;
                break;
            case R.id.btn_paper:
                input = 1;
                break;
            case R.id.btn_scissors:
                input = 2;
                break;
        }

        //Get Computer selected image
        int output = RoshamboUtils.selectRandomImageId(3);

        int result = checkResult(input, output);

        view.updateUI(input, output, result);
    }

    public int checkResult(int input, int output) {
        int result = -1;
        if (input == RoshamboUtils.ROCK_CHOOSEN && output == RoshamboUtils.ROCK_CHOOSEN) {     //User choose Rock,Computer choose Rock
            result = RoshamboUtils.RESULT_TIE;
        } else if (input == RoshamboUtils.ROCK_CHOOSEN && output == RoshamboUtils.PAPER_CHOOSEN) { //User choose Rock,Computer choose Paper
            result = RoshamboUtils.RESULT_LOST;
        } else if (input == RoshamboUtils.ROCK_CHOOSEN && output == RoshamboUtils.SCISSOR_CHOOSEN) { //User choose Rock,Computer choose Scissors
            result = RoshamboUtils.RESULT_WON;
        } else if (input == RoshamboUtils.PAPER_CHOOSEN && output == RoshamboUtils.ROCK_CHOOSEN) { //User choose Paper,Computer choose Rock
            result = RoshamboUtils.RESULT_WON;
        } else if (input == RoshamboUtils.PAPER_CHOOSEN && output == RoshamboUtils.PAPER_CHOOSEN) { //User choose Paper,Computer choose Paper
            result = RoshamboUtils.RESULT_TIE;
        } else if (input == RoshamboUtils.PAPER_CHOOSEN && output == RoshamboUtils.SCISSOR_CHOOSEN) { //User choose Paper,Computer choose Scissors
            result = RoshamboUtils.RESULT_LOST;
        } else if (input == RoshamboUtils.SCISSOR_CHOOSEN && output == RoshamboUtils.ROCK_CHOOSEN) {//User choose Scissors,Computer choose Rock
            result = RoshamboUtils.RESULT_LOST;
        } else if (input == RoshamboUtils.SCISSOR_CHOOSEN && output == RoshamboUtils.PAPER_CHOOSEN) { //User choose Scissors,Computer choose Paper
            result = RoshamboUtils.RESULT_WON;
        } else if (input == RoshamboUtils.SCISSOR_CHOOSEN && output == RoshamboUtils.SCISSOR_CHOOSEN) { //User choose Scissors,Computer choose Scissors
            result = RoshamboUtils.RESULT_TIE;
        }
        return result;
    }

}
