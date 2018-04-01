package com.gig8.coinj;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.gig8.coinj.test", appContext.getPackageName());
    }

    @Test
    public void hashBytes() {
        byte[] bytes = new byte[100];
        byte[] hashed = X13.getHash(bytes);
        String result = X13.getHex(hashed);
        android.util.Log.i("hashBytes", result);

        assertEquals("3BEB76083F05AFF1B846E32D6EB29217D49DB162A6265E91568F59DD9220289D", result);
    }
}