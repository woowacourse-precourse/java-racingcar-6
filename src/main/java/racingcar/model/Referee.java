package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    private List<String> winnerNameList;
    private int winnerStep;

    public Referee() {
        winnerNameList = new ArrayList<>();
    }

    public void findWinnerDistance(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            winnerStep = findMaxDistance(car.getCurrentPosition());
        }
    }

    public int findMaxDistance(int currentPosition) {
        return Math.max(currentPosition, winnerStep);
    }

    public List<String> winnerNameList(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            if (winnerStep == car.getCurrentPosition()) {
                winnerNameList.add(car.getName());
            }
        }
        return Collections.unmodifiableList(winnerNameList);
    }


}
