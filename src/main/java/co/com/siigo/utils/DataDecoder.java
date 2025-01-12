package co.com.siigo.utils;

import java.util.Base64;

public class DataDecoder {

    private DataDecoder() {
    }

    public static String decode(String encodedData) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedData));
    }
}
