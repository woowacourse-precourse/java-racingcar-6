package racingcar.domain;

import racingcar.system.SystemConstant;

import java.util.List;

public class RoundManager {

    public void moveCars(List<Car> cars){
        cars.forEach(car -> {
            if(shouldCarMove())
                car.move();
        });
    }

    private boolean shouldCarMove(){
        int randomValue = RandomNumberGenerator.randomNumGenerate();
        return randomValue >= SystemConstant.MIN_MOVE_THRESHOLD;
    }
}
