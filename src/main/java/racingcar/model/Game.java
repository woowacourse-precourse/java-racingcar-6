package racingcar.model;

import java.util.ArrayList;

public class Game {
    public ArrayList<Car> carList = new ArrayList<>();
    public int round;
    private final ArrayList<String> winnerNameList = new ArrayList<>();
    private int maxScore;

    public void updateCar(Car car) {
        carList.add(car);
    }

    public void updateWinners(Car car) {
        if (car.score > maxScore) {
            maxScore = car.score;
            winnerNameList.clear();
        }
        if (car.score == maxScore) {
            winnerNameList.add(car.name);
        }
    }

    public ArrayList<String> getWinners() {
        return winnerNameList;
    }
}
