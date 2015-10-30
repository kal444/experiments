/**
 *
 */
package com.yellowaxe.testing;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaBean;

/**
 * @author khuang
 *
 */
public class BeanTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LazyDynaBean b = new LazyDynaBean();

        b.set("test", null);

        System.out.println(b.get("test"));

        Map m = new HashMap<String, String>();

        m.put("test", null);

        System.out.println(m.get("test"));
    }

}
