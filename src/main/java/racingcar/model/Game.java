package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private final GameScore gameScore;
    private final List<RacingCar> racingCars;

    public Game(List<String> cars) {
        this.racingCars = initRacingCars(cars);
        this.gameScore = initScore(racingCars);
    }


    private List<RacingCar> initRacingCars(List<String> cars) {
        return cars.stream()
                .map(RacingCar::new)
                .toList();
    }

    private GameScore initScore(List<RacingCar> racingCars) {
        Map<RacingCar, String> gameScore = new LinkedHashMap<>();
        for (RacingCar racingCar : racingCars) {
            gameScore.put(racingCar, CarStatus.STOP.getOutput());
        }
        return new GameScore(gameScore);
    }

    public GameScore playOnce(){
        for (RacingCar racingCar : racingCars) {
            gameScore.update(racingCar, () -> Randoms.pickNumberInRange(0, 9));
        }
        return gameScore;
    }
}
