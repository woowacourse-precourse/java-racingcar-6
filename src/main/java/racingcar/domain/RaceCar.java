package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceCar {
    public List<String> names = new ArrayList<>();
    public List<String> moveDistance = new ArrayList<>();

    public RaceCar(List<String> carName) {
        for (int i = 0; i < carName.size(); i++) {
            names.add(carName.get(i));
            moveDistance.add("");
        }
    }

    public void forward(List<Integer> randomNumber) {
        for (int i = 0; i < names.size(); i++) {
            if (randomNumber.get(i) >= 4) {
                moveDistance.set(i, moveDistance.get(i) + "-");
            }
        }
    }

    public String winner() {
        String winner = "";
        int max = 0;
        for (int i = 0; i < moveDistance.size(); i++) {
            if (max < moveDistance.get(i).length()) {
                max = moveDistance.get(i).length();
            }
        }
        for (int i = 0; i < moveDistance.size(); i++) {
            if (winner.isEmpty() && max == moveDistance.get(i).length()) {
                winner = names.get(i);
            } else if (!winner.isEmpty() && max == moveDistance.get(i).length()) {
                winner = winner + ", " + names.get(i);
            }
        }
        return winner;
    }
}
