package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.data.EndpointAsyncTast;
import com.udacity.gradle.builditbigger.model.OnJokeReceive;
import com.udacity.gradle.builditbigger.utility.Costants;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


@RunWith(AndroidJUnit4.class)
public class JokeTest extends ApplicationTestCase<Application> implements OnJokeReceive {

    private CountDownLatch mStartSignal;
    private String mJoke;

    public JokeTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            new EndpointAsyncTast().execute(this);
            mStartSignal = new CountDownLatch(Costants.TEST_START_COUNT);
            mStartSignal.await(Costants.TEST_JOKE_TIMEOUT, TimeUnit.SECONDS);
            assertFalse(Costants.TEST_MSG_NULL_EMPTY, TextUtils.isEmpty(mJoke));
        } catch (InterruptedException ex) {
            fail();
        }
    }

    @Override
    public void onReceive(String string) {
        mJoke = string;
        mStartSignal.countDown();
    }
}
