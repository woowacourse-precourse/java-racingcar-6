package racingcar.Car;

import racingcar.Constants.CarConstants;
import java.util.List;
import java.util.ArrayList;
public class Car {
    private final String name;
    private final List<Integer> positions;

    public Car(String name) {
        this.name = name;
        this.positions = new ArrayList<>();
        positions.add(CarConstants.START_POSITION);
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return positions.get(positions.size() - 1);
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public void move(int distance) {
        int lastPosition = getCurrentPosition();
        positions.add(lastPosition + distance);
    }
}