package model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> winner;

    public void competeCars(Cars cars) {
        List<Integer> scores = new ArrayList<>();
        for (Car car : cars) {
            scores.add(car.getPosition());
        }

        int maxPosition = -1;
        for (int score : scores) {
            maxPosition = Math.max(maxPosition, score);
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
