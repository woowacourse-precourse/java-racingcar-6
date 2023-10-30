package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public Cars(List<String> carNames, int tryCount) {
        insertCars(carNames);
        this.tryCount = tryCount;
    }

    private void insertCars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public Map<String, Integer> getScores() {
        Map<String, Integer> scores = new HashMap<>();
        cars.forEach(car -> scores.put(car.getName(), car.getScore()));
        return scores;
    }

    public void moveAllCar() {
        cars.forEach(car -> car.move());
        tryCount--;
    }

    public boolean isCompleted() {
        return tryCount == 0;
    }

    public List<String> findWinner() {
        return getScores().entrySet().stream()
                .filter(entry -> entry.getValue() == Collections.max(getScores().values()))
                .map(Map.Entry::getKey)
                .toList();
    }
}
