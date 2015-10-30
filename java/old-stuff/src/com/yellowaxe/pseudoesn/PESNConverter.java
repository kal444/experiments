/*
 * PESNConverter.java
 *
 * Created on January 13, 2006, 4:53 PM
 */

package com.yellowaxe.pseudoesn;

import java.security.MessageDigest;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author khuang
 */
public class PESNConverter {

	protected final static Log log = LogFactory.getLog(PESNConverter.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {

    	ResourceBundle messages = null;

    	// make sure that the classname specified is a fully qualified class name
    	String classname = "com.yellowaxe.pseudoesn.pseudo";
        try {
//        	System.out.println(ClassLoader.getSystemClassLoader().getResource(classname));
//        	messages = new PropertyResourceBundle(ClassLoader.getSystemClassLoader().getResourceAsStream(classname));
            messages = ResourceBundle.getBundle(classname);
        } catch (NullPointerException npe) {
            System.out.println("NPE: Could not find: "+classname);
        } catch (MissingResourceException mre) {
            System.out.println("MRE: Could not find: "+classname);
        }

        System.out.println("got message bundle: " + messages);

    	String hexString = "FFFFFFFF";
    	for (int i = 0; i < hexString.length(); i++) {
    		char c = hexString.charAt(0);
        	String out = Integer.toBinaryString(Integer.valueOf(""+c, 16).intValue());
        	for (int j = 0, len = out.length(); j < 4 - len; j++) {
        		out = "0" + out;
        	}
        	System.out.print(out + " ");
    	}
    	System.out.println();

        MessageDigest digester = MessageDigest.getInstance("SHA-1");
        digester.reset();

        // input
        String testString = "FF000001123456";

        // convert HexString to ByteArray
        byte [] testBA = new byte[testString.length()/2];
        for (int i = 0; i < testString.length(); i+=2) {
            testBA[i/2] = (byte)((Integer.parseInt(testString.substring(i, i+2) , 16)) & 0xFF);
        }

        digester.update(testBA);
        byte [] digest = digester.digest();

        // covert ByteArray to HexString
        StringBuffer hexOut = new StringBuffer();
        for (byte element : digest) {
            String hexC = Integer.toHexString(0xFF & element).toUpperCase();
            if (hexC.length() == 1) {
                hexC = "0" + hexC;
            }
            hexOut.append(hexC);
        }

        // output
        String pESN = "80" + hexOut.toString().substring(hexOut.length() - 3*2);

        System.out.println("pESN: " + pESN);

        log.debug("done");
    }

}
