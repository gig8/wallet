package com.gig8.coinj;

public class X13 {

    // Used to load the 'native-crypto' library on startup.
    static {
        System.loadLibrary("native-crypto");
    }

    private static final String    HEXES    = "0123456789abcdef";

    public static String getHex(byte[] raw) {
        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for (final byte b : raw) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

    public static byte[] x13Digest(byte[] input, int offset, int length)
    {
        byte [] buf = new byte[length];
        for(int i = 0; i < length; ++i)
        {
            buf[i] = input[offset + i];
        }
        return x13Digest(buf);
    }

    public static byte[] x13Digest(byte[] input) {
        //long start = System.currentTimeMillis();
        try {
            return getHash(input);
            /*long start = System.currentTimeMillis();
            byte [] result = x11_native(input);
            long end1 = System.currentTimeMillis();
            byte [] result2 = x11(input);
            long end2 = System.currentTimeMillis();
            log.info("x11: native {} / java {}", end1-start, end2-end1);
            return result;*/
        } catch (Exception e) {
            return null;
        }
        finally {
            //long time = System.currentTimeMillis()-start;
            //log.info("X11 Hash time: {} ms per block", time);
        }
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public static native byte[] getHash(byte[] bytes);
}
