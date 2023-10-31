package racingcar.util;

import racingcar.domain.Car;


import java.util.List;


public class RacingSimulator {
    String Number;


    public RacingSimulator(String number) {
        Number = number;
    }

    public void playSimulator(List<Car> cars){

        for(Car car : cars) {
            if (RandomGenerator.generateNumber()>=4){
                  car.addResult();
            }
        }
    }
}
