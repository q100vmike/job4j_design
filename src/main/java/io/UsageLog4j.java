package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        byte size = 10;
        short distance = 500;
        long money = 1000000000L;
        char category = 'M';
        float weight = 80.5f;
        double height = 180.5;
        boolean flag = true;

        LOG.debug("User info name : {}, age : {}, size : {}"
                + ", distance : {}, money : {}, category : {}, weight : {}, flag : {}",
                name, age, size, distance, money, category, weight, flag);
    }
}