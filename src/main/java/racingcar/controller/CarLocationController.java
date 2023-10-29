package racingcar.controller;

import racingcar.generator.RandomNumberGenerator;

public class CarForward {
    int randomnumber=RandomNumberGenerator.RandomNumber();
    public void forward(int location){
        if(randomnumber>=4) {
            location += 1;
        }
    }


}
