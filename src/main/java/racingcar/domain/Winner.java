package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Integer location;

    private final List<String> winnerNames = new ArrayList<>();

    public Winner(Integer location) {
        this.location = location;
    }

    public void judgeRacingWinner(List<Car> carList) {
        for (Car car : carList) {
            if (car.getLocation() == location) {
                winnerNames.add(car.getName());
            }
        }
    }

    public String getWinners() {
        String[] names = winnerNames.toArray(String[]::new);

        return String.join(",");
    }
}
