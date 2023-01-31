package com.diamond.kata;

import com.diamond.kata.util.DiamondUtil;

public class App {
    public static void main( String[] args ) {
        DiamondUtil diamondUtil = new DiamondUtil();
        if (args.length!=1) {
            // Wrong arg length
            System.err.println("Please input 1 argument");
        } else if (args[0].length()!=1) {
            // Not a single char
            System.err.println("Please input correct argument with 1 character");
        } else if (diamondUtil.isValidateChar(args[0].charAt(0))) {
            // Not a correct char
            System.err.println("Please input the argument between 'A' to 'Z'");
        } else {
            String output = diamondUtil.draw(args[0].charAt(0), ' ');
            System.out.println(output);
        }
    }

}
