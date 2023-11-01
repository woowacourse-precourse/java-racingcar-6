package racingcar.controller;


import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    private int highScore;
    List<String> winnerList;

    List<Integer> isNumberMoreThan4(List<Integer> carRandomNumbers) {
        for (int i = 0; i < carRandomNumbers.size(); i++) {
            if (carRandomNumbers.get(i) < 4) {
                carRandomNumbers.set(i, 0);
            }
        }
        return carRandomNumbers;
    }

    public List<String> determineWinner(List<Car> sortedCars) {
        winnerList = new ArrayList<>();
        highScore = sortedCars.get(0).getCarBoost();

        for (int i = 0; i < sortedCars.size(); i++) {
            if (highScore == sortedCars.get(i).getCarBoost()) {
                winnerList.add(sortedCars.get(i).getCarName());
            }
        }
        return winnerList;
    }


}
