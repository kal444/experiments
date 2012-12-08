/*
 * Created on Aug 1, 2005
 */
package com.yellowaxe.testing;

/**
 * @author khuang
 */
public class ByteArrayUtils {
    public static String ByteArrayToHexString(byte [] array) {
        // covert ByteArray to HexString
        StringBuffer hexOut = new StringBuffer();
        for (byte element : array) {
            String hexC = Integer.toHexString(0xFF & element).toUpperCase();
            if (hexC.length() == 1) {
                hexC = "0" + hexC;
            }
            hexOut.append(hexC);
        }
        return hexOut.toString();
    }

    public static byte[] HexStringToByteArray(String hexstring) {
        // convert HexString to ByteArray
        byte [] array = new byte[hexstring.length()/2];
        for (int i = 0; i < hexstring.length(); i+=2) {
            array[i/2] = (byte)((Integer.parseInt(hexstring.substring(i, i+2) , 16)) & 0xFF);
        }
        return array;
    }

    /**
     * This conversion can only handle simple chars (ASCII only)
     * @param array the char [] to be converted
     * @return the byte [] generated
     */
    public static byte[] CharArrayToByteArray(char[] array) {
        // convert CharArray to ByteArray
        byte [] result = new byte[array.length];
        for (int i=0; i<result.length; i++) {
            result[i] = (byte)array[i];
        }
        return result;
    }
}
