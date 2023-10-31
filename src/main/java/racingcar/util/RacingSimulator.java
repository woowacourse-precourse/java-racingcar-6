package racingcar.util;

import racingcar.domain.Car;


import java.util.List;


public class RacingSimulator {
    int number;


    public RacingSimulator(int number) {
        this.number = number;
    }

    private void minusNumber(){
        --number;
    }

    public boolean checkZero(){
        if(number==0){
            return false;
        }
        return true;
    }

    public void playSimulator(List<Car> cars){

        for(Car car : cars) {
            if (RandomGenerator.generateNumber()>=4){
                  car.addResult();
            }
        }
    }


}
