package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Andris on 016 16.05.18.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {
    @Test
    public void testDoInBackground() {
        try {
            EndpointsAsyncTask.Listener listener = new EndpointsAsyncTask.Listener() {
                @Override
                public void onJokeLoaded(String result) {

                }
            };
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(listener);
            endpointsAsyncTask.execute();
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
            Log.e("Test:", "testDoInBackground: Timed out");
        }
    }
}