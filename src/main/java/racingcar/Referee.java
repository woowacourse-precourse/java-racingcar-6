package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Referee {
    private final Judgment judgment;

    public Referee() {
        this.judgment = new Judgment();
    }

    public List<String> choiceWinners(HashMap<String, Integer> cars) {
        List<String> winners = new ArrayList<>();
        judgment.firstCarPosition(cars);
        cars.forEach((car, position) -> {
            if (judgment.isWinner(position)) {
                winners.add(car);
            }
        });
        return winners;
    }
}
