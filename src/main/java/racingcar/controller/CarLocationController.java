package racingcar.controller;

import racingcar.generator.RandomNumberGenerator;

public class CarLocationController {

    public static int forward(int location){
        int randomnumber=RandomNumberGenerator.RandomNumber();
        System.out.println(randomnumber);
        if(randomnumber>=4) {
            location += 1;
        }
        return location;
    }


}
