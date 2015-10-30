/*
 * TomcatDeployTesting.java
 *
 * Created on January 13, 2006, 5:05 PM
 */

package com.yellowaxe.testing;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author khuang
 */
public class TomcatDeployTesting {

    /** Creates a new instance of TomcatDeployTesting */
    public TomcatDeployTesting() {
        String file = "file:///C:/billingdashboard.war";
        deploy(file);
        System.out.println("go test to see if you can delete the war file");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void deploy(String war) {
        // Use embedded META-INF/context.xml if present
        URL contextXml = null;
        InputStream stream = null;
        try {
            String contextWar = war;
            if (war.startsWith("file:")) {
                if (war.endsWith(".war")) {
                    contextWar = "jar:" + war + "!/";
                } else {
                    contextWar = war + '/';
                }
            }
            System.out.println("file url is: " + contextWar);
            contextXml = new URL(contextWar +
                    "META-INF/context.xml");
            System.out.println("url: " + contextXml);
            stream = contextXml.openStream();
            System.out.println("opened stream");
            // WAR contains META-INF/context.xml resource - install
            System.out.println("installing...");
            return;
        } catch (FileNotFoundException fnfe) {
            // No META-INF/context.xml resource - keep going
            System.out.println(" caught: " + fnfe);
            return;
        } catch (Throwable t) {
            System.out.println(" caught: " + t);
            return;
        } finally {
            System.out.println("finally");
            if (stream != null) {
                try {
                    stream.close();
                    System.out.println("closed stream");
                } catch (Throwable t) {
                    // do nothing
                }
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TomcatDeployTesting test = new TomcatDeployTesting();
    }

}
