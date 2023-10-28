package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCars {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(List<String> racingCarNames) {
        setRacingCars(racingCarNames);
    }

    private void setRacingCars(List<String> racingCarsName) {
        for (String racingCarName : racingCarsName) {
            racingCars.add(new RacingCar(racingCarName));
        }
    }

    public List<String> getWinners() {
        int maxMoveDistance = getMaxMoveDistance();
        List<String> winners = findWinners(maxMoveDistance);
        return winners;
    }

    private int getMaxMoveDistance() {
        return racingCars.stream()
                .mapToInt(RacingCar::getMoveDistance)
                .max()
                .getAsInt();
    }

    private List<String> findWinners(int maxMoveDistance) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getMoveDistance() == maxMoveDistance)
                .map(RacingCar::getName)
                .toList();
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    public Map<String, Integer> makeResultMap() {
        ResultMap resultMap = new ResultMap(racingCars);
        return resultMap.getResultMap();
    }
}
