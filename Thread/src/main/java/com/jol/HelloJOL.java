package com.jol;

import org.openjdk.jol.info.ClassLayout;

/**
* 
* @className HelloJOL
* @author liuc
* @date 2020-04-05 15:51
* @since JDK 1.8
**/
public class HelloJOL {
    public static void main(String[] args) {
        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
       /* o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());*/
        System.out.println("==============================");
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
      /*  System.out.println("==============================");
        System.out.println(ClassLayout.parseInstance(Object.class).toPrintable());*/
    }
}
