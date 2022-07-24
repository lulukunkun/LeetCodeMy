package com.lukun.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

/**
 * @ClassName test
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/5 19:22
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {


    }
}

class StaticStuff {
    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String args[]) {
        System.out.println("x=" + x);
    }

    static {
        x /= 3;
    }
}

class HasStatic  {
    private static int x = 100;

    public static void main(String args[]) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);
        System.out.println();
    }

}