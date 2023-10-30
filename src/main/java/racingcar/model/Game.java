package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private GameScore gameScore;
    private List<RacingCar> racingCars;

    public Game(List<String> cars) {
        this.racingCars = initRacingCars(cars);
        this.gameScore = new GameScore(initScore(racingCars));
    }


    private List<RacingCar> initRacingCars(List<String> cars) {
        return cars.stream()
                .map(RacingCar::new)
                .toList();
    }

    private Map<RacingCar, String> initScore(List<RacingCar> racingCars) {
        Map<RacingCar, String> gameScore = new HashMap<>();
        for (RacingCar racingCar : racingCars) {
            gameScore.put(racingCar, CarStatus.STOP.getOutput());
        }
        return gameScore;
    }


}
