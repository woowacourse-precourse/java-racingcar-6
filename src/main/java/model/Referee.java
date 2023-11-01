package model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> winner = new ArrayList<>();

    public void competeCars(Cars cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }
    }

    public List<String> getWinner() {
        return winner;
    }
}
