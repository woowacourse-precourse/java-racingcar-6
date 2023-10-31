package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarList {
    private List<String> carNames;
    private List<Integer> carPositions;
    Car car = new Car();

//    public CarList(List<String> carNames) {
//        this.carNames = carNames;
//    }

    public List<Integer> initialPosition(int carNumber) {
        List<Integer> carPositions = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carPositions.add(0);
        }
        System.out.println(carPositions);
        return carPositions;
    }

//    public int setCarPosition(int orderOfCar, List<Integer> carPositions) {
//        if (car.isGoingForward() == true) {
//            int currentPosition = carPositions.get(orderOfCar);
//            carPositions.set(orderOfCar, currentPosition + 1);
//        }
//
//        return carPositions.get(orderOfCar);
//    }

    public List<Integer> setCarPositions(List<Integer> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            if (car.isGoingForward() == true) {
                int currentPosition = carPositions.get(i);
                carPositions.set(i, currentPosition + 1);
            }
        }
        return carPositions;
    }

    public List<String> decideWinner(List<Integer> carPositions, List<String> carNames) {
        Integer max = Collections.max(carPositions);

        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < carPositions.size(); i++) {
            if (carPositions.get(i) == max) {
                winnerNames.add(carNames.get(i));
            }
        }

        return winnerNames;
    }
}
