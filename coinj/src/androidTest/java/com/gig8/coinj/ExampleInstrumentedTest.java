package com.gig8.coinj;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.bitcoinj.core.Sha256Hash;
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
        byte[] hashed = X13.x13Digest(bytes);
        String result = X13.getHex(hashed);
        android.util.Log.i("hashBytes", result);

        assertEquals("3beb76083f05aff1b846e32d6eb29217d49db162a6265e91568f59dd9220289d", result);
    }

    @Test
    public void hashGenesis() {
        byte[] bytes = new byte[]{
                (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0xd6, (byte) 0x54, (byte) 0x17, (byte) 0x18, (byte) 0xc8, (byte) 0xe2, (byte) 0xf2, (byte) 0x1c, (byte) 0x67, (byte) 0xd4, (byte) 0x0c, (byte) 0x53, (byte) 0x22, (byte) 0x4d, (byte) 0x1f, (byte) 0x78,
                (byte) 0xdb, (byte) 0x2a, (byte) 0xca, (byte) 0xa5, (byte) 0xc8, (byte) 0xcd, (byte) 0xb2, (byte) 0x81, (byte) 0xfc, (byte) 0x36, (byte) 0x5a, (byte) 0x3a, (byte) 0xc9, (byte) 0xb0, (byte) 0xd8, (byte) 0xb3,
                (byte) 0xd8, (byte) 0xcb, (byte) 0xae, (byte) 0x5a,
                (byte) 0xff, (byte) 0xff, (byte) 0x0f, (byte) 0x1e,
                (byte) 0xb6, (byte) 0x38, (byte) 0x02, (byte) 0x00,
        };

        byte[] firstHashed = X13.x13Digest(bytes);
        String firstResult = X13.getHex(firstHashed);
        android.util.Log.i("firstHashed", firstResult);

        Sha256Hash hashed = Sha256Hash.wrapReversed(firstHashed);
        String result = hashed.toString();
        android.util.Log.i("hashBytes", result);

        assertEquals("00000fea25f87416682baa54946a1d156909d0959588eb573a0ae16a64230c61", result);
    }
}