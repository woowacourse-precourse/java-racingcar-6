package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Win {
    private static List<Car> cars;
    private static int winnerValue;

    public Win(List<Car> cars) {
        Win.cars = cars;
    }

    public String[] getWin() {
        String[] winnerNames = new String[ranking().size()];
        return ranking().toArray(winnerNames);
    }

    private List<String> ranking() {
        List<String> carNames = new ArrayList<>();
        Collections.sort(carNames);
        winnerValue = cars.get(0).getPosition();

        for (Car car : cars) {
            if (winnerValue == car.getPosition()) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }
}
