package com.app.roshambo.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class RoshamboUtilsTest {

    @Test
    public void testSelectRandomImageIdP1() {
        assertTrue(RoshamboUtils.selectRandomImageId(3) <= 2);
    }

    @Test
    public void testSelectRandomImageIdN1() {
        assertFalse(RoshamboUtils.selectRandomImageId(3) > 2);
    }

    @Test
    public void testSelectRandomImageIdN2() {
        assertFalse(RoshamboUtils.selectRandomImageId(3) < 0);
    }

}
