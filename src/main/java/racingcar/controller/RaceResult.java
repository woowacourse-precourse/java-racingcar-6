package racingcar.controller;
import racingcar.model.Race;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private Race race;

    public RaceResult(Race race){
        this.race = race;
    }

    private int maxCount() {

        int maxMove = -1;

        for (Car car : race.getCars()) {

            if (car.getMove() > maxMove) {
                maxMove = car.getMove();
            }
        }
        return maxMove;
    }

    public String checkWinner() {

        int maxMove = maxCount();
        List<String> winnerCar = new ArrayList<>();

        for (Car car : race.getCars()) {

            if (car.getMove() == maxMove) {
                winnerCar.add(car.getName());
            }
        }
        return String.join(", ", winnerCar);
    }
}
