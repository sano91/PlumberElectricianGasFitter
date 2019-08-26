package com.sano.util;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static int getRandomNumberInGivenRange(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to+1);
    }

    public static boolean giveFortune(int luckyPercentage){
        return luckyPercentage >= getRandomNumberInGivenRange(1,100);
    }
}
