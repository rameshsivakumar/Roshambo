package com.app.roshambo;

import com.app.roshambo.MainActivityPresenter;
import com.app.roshambo.utils.RoshamboUtils;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class MainActivityPresenterTest {

    int computerOutput = -1;

    MainActivityPresenter presenter;

    @Before
    public void init() {
        computerOutput = RoshamboUtils.selectRandomImageId(3);
        presenter = new MainActivityPresenter();
    }

    @Test
    public void testCheckResultP1() {
        int result = presenter.checkResult(RoshamboUtils.ROCK_CHOOSEN, RoshamboUtils.ROCK_CHOOSEN);
        assertTrue(result <= RoshamboUtils.RESULT_TIE);
    }

    @Test
    public void testCheckResultP2() {
        int result = presenter.checkResult(RoshamboUtils.ROCK_CHOOSEN, RoshamboUtils.PAPER_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_LOST);
    }

    @Test
    public void testCheckResultP3() {
        int result = presenter.checkResult(RoshamboUtils.ROCK_CHOOSEN, RoshamboUtils.SCISSOR_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_WON);
    }

    @Test
    public void testCheckResultP4() {
        int result = presenter.checkResult(RoshamboUtils.PAPER_CHOOSEN, RoshamboUtils.ROCK_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_WON);
    }

    @Test
    public void testCheckResultP5() {
        int result = presenter.checkResult(RoshamboUtils.PAPER_CHOOSEN, RoshamboUtils.PAPER_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_TIE);
    }

    @Test
    public void testCheckResultP6() {
        int result = presenter.checkResult(RoshamboUtils.PAPER_CHOOSEN, RoshamboUtils.SCISSOR_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_LOST);
    }

    @Test
    public void testCheckResultP7() {
        int result = presenter.checkResult(RoshamboUtils.SCISSOR_CHOOSEN, RoshamboUtils.ROCK_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_LOST);
    }

    @Test
    public void testCheckResultP8() {
        int result = presenter.checkResult(RoshamboUtils.SCISSOR_CHOOSEN, RoshamboUtils.PAPER_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_WON);
    }

    @Test
    public void testCheckResultP9() {
        int result = presenter.checkResult(RoshamboUtils.SCISSOR_CHOOSEN, RoshamboUtils.SCISSOR_CHOOSEN);
        assertTrue(result == RoshamboUtils.RESULT_TIE);
    }

    @Test
    public void testCheckResultN1() {
        int result = presenter.checkResult(RoshamboUtils.SCISSOR_CHOOSEN, computerOutput);
        assertTrue(result != -1);
    }

    @Test
    public void testCheckResultN2() {
        int result = presenter.checkResult(RoshamboUtils.SCISSOR_CHOOSEN, -1);
        assertTrue(result == -1);
    }

}
