package racingcar.model;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final JudgeWinner judgeWinner;


    public RacingGame(List<String> names, JudgeWinner judgeWinner, NumberGenerator numberGenerator) {
        this.cars = new Cars(names, numberGenerator);
        this.judgeWinner = judgeWinner;
    }

    public void move() {
        cars.move();
    }

    public List<CarDTO> status() {
        return cars.getStatus();
    }

    public List<String> judgeWinner() {
        return judgeWinner.judge(cars)
                .stream()
                .map(CarDTO::name)
                .toList();
    }
}
