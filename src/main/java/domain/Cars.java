package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MOVE_NUM = 4;

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> getScores() {
        Map<String, Integer> scores = new HashMap<>();

        for (Car car : cars) {
            scores.put(car.getName(), car.getScore());
        }

        return scores;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void insertCar(Car car) {
        cars.add(car);
    }

    public void moveAllCar() {
        tryCount--;

        for (Car car : cars) {
            if (Randoms.pickNumberInRange(MIN_NUM, MAX_NUM) >= MOVE_NUM) {
                car.move();
            }
        }
    }

    public boolean isCompleted() {
        return tryCount == 0;
    }


}
