package com.yellowaxe.java8;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void simple_lambda() throws Exception {

        // simple expression saves a return statement
        Callable<String> callable = () -> "I am called";
        /*
        instead of
        new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "I am called";
            }
        };
        */
        assertEquals("I am called", callable.call());
        System.out.println(callable.getClass().getName());

        // parameter types can be inferred
        Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);
        assertEquals(0, comparator.compare("AB", "ab"));
        System.out.println(comparator.getClass().getName());

        // scoping causes "this" to point to the instance of LambdaTest instead of the lambda expression itself
        ((Runnable) () -> {
            assertEquals("LambdaTest", this.toString());
        }).run();

        // this is different than anon-inner classes
        // practically, this makes sense, as I can make use of "this" in an anon-inner class
        (new Runnable() {
            @Override
            public void run() {
                assertNotEquals("LambdaTest", this.toString());
                System.out.println(this.toString());
            }
        }).run();

        // variable capture
        int size = 100;
        ((Runnable) () -> System.out.println(size)).run();
        //size++; // this causes a compilation error when uncommented - size needs to be effectively final

        Object foo = new Object();
        ((Runnable) () -> System.out.println(foo)).run();
        //foo = new Object();

        // method reference
        // take
        //Comparator<String> comparator1 = (s1, s2) -> s1.compareToIgnoreCase(s2);
        // and replace it with
        // - compare using an existing method. smart enough to know o1.method(o2).
        Comparator<String> comparator2 = String::compareToIgnoreCase;
        // - can refer to a method on instance too. The instance is captured
        Set<String> items = Collections.singleton("OK");
        Predicate<String> doesContain = items::contains;
        // likely impl of the method reference
        //Set<String> reference = items;
        //Predicate<String> doesContain = (s) -> reference.contains(s);
        items = Collections.singleton("NOT OK"); // ha, no compilation error since old reference was "captured" already
        assertFalse(items.contains("OK"));
        assertTrue(doesContain.test("OK"));
    }

    @Override
    public String toString() {
        return LambdaTest.class.getSimpleName();
    }

    @Test
    public void default_method() throws Exception {
        // default method is Java8's answer for mixins
        Foo foo = new Foo() {
            @Override
            public String bar() {
                return "a new bar";
            }
        };

        System.out.println(foo.iHaveCode());
        System.out.println(Foo.staticToo());

    }

    private static interface Foo {
        String bar();

        default String iHaveCode() {
            return "I have seen " + bar();
        }

        static String staticToo() {
            return "statics in interfaces!";
        }
    }

}
