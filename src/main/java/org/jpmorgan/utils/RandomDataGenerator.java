package org.jpmorgan.utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * This class is to create Random data using Faker Libarary at run time for easy creation of Payload Request.
 */
public class RandomDataGenerator {

    private static Faker faker = new Faker();
    public static String generateTitle(){
       return faker.name().title();

    }

    public static String generateFullName(){
        return faker.name().fullName();

    }

    public static String generateEmailAddress(){

       return faker.internet().emailAddress();
    }

    public static String createRandomString(int digit){
        return RandomStringUtils.randomAlphabetic(digit);
    }


    public static String createRandomNumber(int digit){
        return faker.number().digits(digit);
    }

}
