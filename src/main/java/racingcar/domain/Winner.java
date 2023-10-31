package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private Car currentWinner;
    private List<String> candidates = new ArrayList<>();;

    public Winner(Car currentWinner) {
        candidates.clear();
        this.currentWinner = currentWinner;
        this.candidates.add(currentWinner.getName());
    }

    public void compare(Car car) {
        int compareState = currentWinner.compareTo(car);

        if (isChangeWinner(compareState)) {
            candidates.clear();
            currentWinner = car;
        }
        if (isAddWinner(compareState)) {
            candidates.add(car.getName());
        }
    }

    public List<String> getCandidates() {
        return candidates;
    }

    private boolean isAddWinner(int compareState) {
        return compareState <= 0;
    }

    private boolean isChangeWinner(int compareState) {
        return compareState < 0;
    }
}
