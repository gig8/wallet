package com.gig8.coinj;

public class X13 {

    // Used to load the 'native-x13' library on startup.
    static {
        System.loadLibrary("native-x13");
    }

    private static final String    HEXES    = "0123456789ABCDEF";

    public static String getHex(byte[] raw) {
        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for (final byte b : raw) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public static native byte[] getHash(byte[] bytes);
}
