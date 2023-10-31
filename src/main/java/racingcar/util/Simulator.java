package racingcar.util;

import racingcar.domain.Car;


import java.util.List;


public class Simulator {
    String Number;


    public Simulator(String number) {
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
