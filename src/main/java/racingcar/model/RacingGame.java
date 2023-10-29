package racingcar.model;

import java.util.List;
import racingcar.JudgeWinner;

public class RacingGame {

    private final Cars cars;
    private final JudgeWinner judgeWinner;

    public RacingGame(Cars cars, JudgeWinner judgeWinner){
        this.cars = cars;
        this.judgeWinner = judgeWinner;
    }

    public void moveOneStep() {
        cars.moveOneStep();
    }

    public List<Car> getStatus(){
        return cars.getStatus();
    }
}
