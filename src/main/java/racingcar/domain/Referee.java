package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public List<Car> identifyWinner(List<Car> carList) {
        List<Car> winner = new ArrayList<>();

        List<Integer> forwardList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            forwardList.add(carList.get(i).getForwardDistance().length());
        }
        int maxForward = Collections.max(forwardList);

        for (Car car : carList) {
            if (car.getForwardDistance().length()==maxForward) {
                winner.add(car);
            }
        }
        return winner;
    }
}
