package com.rscommunityapps.alpha.utils;
import org.apache.commons.lang3.RandomStringUtils;


public class RandomHelper {


    public static String getRandomAlphaNumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String getRandomNumberAsString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String getRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
