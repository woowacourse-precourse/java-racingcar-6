package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> winners;
    private int position;

    public Winner() {
        winners = new ArrayList<>();
        position = 0;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public String getWinnerNames() {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        return String.join(",", names);
    }


    public int getPosition() {
        return position;
    }
}
