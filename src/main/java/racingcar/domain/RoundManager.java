package racingcar.domain;

import java.util.List;
import racingcar.utils.NumberGenerator;

public class RoundManager {
    private List<Car> racingCars;
    private static final int MOVING_FORWARD = 4;
    public RoundManager(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void roundPlay(){
        for (Car car:racingCars){
            if (NumberGenerator.generateRandNum() >= MOVING_FORWARD){
                car.moveForward();
            }
        }
    }

    public void printRoundResult() {
        for (Car car:racingCars){
            System.out.println(car.getState());
        }
        System.out.println();
    }
}
