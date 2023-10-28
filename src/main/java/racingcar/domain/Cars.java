package racingcar.domain;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }

    public void play() {
        for (Car car : cars) {
            car.play();
        }
    }

    public List<List<Integer>> provideAllCumulativeScoreList() {
        List<List<Integer>> roundScores = new ArrayList<>();

        for (Car car : cars) {
            roundScores.add(car.getCumulativeScoreList());
        }
        return roundScores;
    }

    public List<String> provideCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public List<String> determineWinners() {

        List<String> winnerNames = new ArrayList<>();
        int topScore = 0;
        for (Car car : cars) {
            if (topScore < car.getCurrentScore()) {
                topScore = car.getCurrentScore();
                winnerNames.clear();
                winnerNames.add(car.getName());
            }
            if (topScore == car.getCurrentScore()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;

//        Map<String, Integer> winnerResult = new HashMap<>();
//        for (Car car : cars) {
//            winnerResult.put(car.getName(), car.getCurrentScore());
//        }
//
//        int topScore = Collections.max(winnerResult.values());
//
//        return winnerResult.entrySet().stream()
//                .filter(entry -> entry.getValue() == topScore)
//                .map(Map.Entry::getKey)
//                .toList();
    }
}
