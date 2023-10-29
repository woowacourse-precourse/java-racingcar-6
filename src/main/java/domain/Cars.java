package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> getScores() {
        Map<String, Integer> scores = new HashMap<>();
        cars.forEach(car -> scores.put(car.getName(), car.getScore()));
        return scores;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void insertCar(Car car) {
        cars.add(car);
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
