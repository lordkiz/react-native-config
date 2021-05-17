package com.example;

import android.util.Base64;

import junit.framework.TestCase;

public class RNConfigUtilsTest extends TestCase {

    public void testDecode() {
        String unDecoded = BuildConfig.EXAMPLE_KEY;
        String key = BuildConfig.XOR_KEY;

        String decodedString = RNConfigUtils.decode(unDecoded, key);
        String expected = "dontmesswithmykeys";

        assertEquals("Example Key is NOT correctly decoded", expected, decodedString);
    }

    /**
     * Test that the encoded BuildConfig env vars are not just
     * a simple base64 encoded strings
     */
    public void testEncodingIsNotSimpleBase64() {
        String str = "dontmesswithmykeys";
        String envVar = BuildConfig.EXAMPLE_KEY;

        String encodedWithBase64 = Base64.encodeToString(str.getBytes(), Base64.DEFAULT);

        assertTrue("Ooops, The env vars are only base64 encoded", !envVar.equals(encodedWithBase64));

    }
}