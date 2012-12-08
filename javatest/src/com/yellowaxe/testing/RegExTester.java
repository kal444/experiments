/**
 *
 */
package com.yellowaxe.testing;

/**
 * @author KHuang
 *
 */
public class RegExTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "ON HOLD PR000682 Enhance Web Billing and Alternative Media Options";
        String s2 = "PR000750 - Householding Re-Engineer for Business Database Marketing (E0110)";
        String s3 = "ON HOLD - PR000589 Home Device Manager";

        System.out.println(s2.replaceAll("(ON HOLD|ONHOLD|CANCEL|CANCELLED)?[^0-9a-zA-Z]*"+"PR000750"+"[^0-9a-zA-Z]*", ""));
    }

}
