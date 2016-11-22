package com.nelipa.test.s_randomizer;

import java.util.Random;

public class Randomizer {
    public static final String BUNDLE_LAST_RANDOM = "bundle-last-random";

    public int generate(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
