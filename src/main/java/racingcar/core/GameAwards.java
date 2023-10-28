package racingcar.core;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameAwards {
    private final WinnerCheckSystem winnerCheckSystem;

    public GameAwards(final WinnerCheckSystem winnerCheckSystem) {
        this.winnerCheckSystem = winnerCheckSystem;
    }

    public List<String> awards(List<Car> cars) {
        List<Car> winners = winnerCheckSystem.getWinners(cars);
        return getNames(winners);
    }

    public List<String> getNames(List<Car> winners){
        List<String> res = new ArrayList<>();
        for (Car winner : winners) {
            res.add(winner.getName());
        }
        return res;
    }
}
