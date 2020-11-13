package edu.ejb;

import java.util.Random;

public class RandomPrediction {

    String [] arr = new String[] {
            "You will be going on a trip soon",
            "Something exciting is waiting for you",
            "You'll get good news",
            "Can you find the answer to the question"};


   public String getMessage () {
        Random random = new Random();
        int i = random.nextInt(3);
        String s = arr[i];
        return s;
    }

}
