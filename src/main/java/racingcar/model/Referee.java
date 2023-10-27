package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    private List<String> winnerNameList;
    private int winnerStep;

    public Referee(){
        winnerNameList = new ArrayList<>();
    }

    public void findWinnerStep(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            if (winnerStep < car.getCurrentPosition()) {
                winnerStep = car.getCurrentPosition();
            }
        }
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
