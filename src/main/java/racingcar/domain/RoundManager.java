package racingcar.domain;

import java.util.List;

public class RoundManager {

    public void moveCarsInRound(List<Car> cars){
        for(Car car : cars){
            if(shouldCarMove())
                car.move();
        }
    }

    public boolean shouldCarMove(){
        int randomValue = RandomNumberGenerator.randomNumGenerate();
        return randomValue >=4;
    }
}
