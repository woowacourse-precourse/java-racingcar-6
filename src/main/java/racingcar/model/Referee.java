package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    private List<String> winnerNameList;
    private int winnerDistance;

    public Referee() {
        winnerNameList = new ArrayList<>();
    }

    public void findWinnerDistance(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            winnerDistance = findMaxDistance(car.getCurrentPosition());
        }
    }

    private int findMaxDistance(int currentPosition) {
        return Math.max(currentPosition, winnerDistance);
    }

    public List<String> winnerNameList(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            if (winnerDistance == car.getCurrentPosition()) {
                winnerNameList.add(car.getName());
            }
        }
        return Collections.unmodifiableList(winnerNameList);
    }

}
