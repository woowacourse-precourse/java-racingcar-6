package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarWinners {
    private final List<Car> winners;

    private CarWinners(List<Car> winners) {
        this.winners = new ArrayList<>(winners);
    }

    public static CarWinners from(List<Car> winners) {
        return new CarWinners(winners);
    }

    public List<Car> getWinners() {
        return new ArrayList<>(winners);
    }
}
