package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> carList = new ArrayList<>();

    public Winners(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> getWinners() {
        List<String> winnerList = calculateWinners();
        return Collections.unmodifiableList(winnerList);
    }

    private List<String> calculateWinners() {
        List<String> winnerList = new ArrayList<>();
        int max = findMaxMovement();
        for (Car car : carList) {
            if (car.getMovement() == max) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int findMaxMovement() {
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            max = Math.max(max, car.getMovement());
        }
        return max;
    }

}
