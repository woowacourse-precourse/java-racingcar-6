package racingcar.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    private Map<Car, Integer> MovingDistance;

    public Race() {
        MovingDistance = new LinkedHashMap<>();
    }

    public void addCar(Car car) {
        MovingDistance.put(car, Constant.START_NUM.value);
    }

    public void run() {
        for (Car car : MovingDistance.keySet()) {
            MovingDistance.put(car, MovingDistance.get(car) + car.move());
        }
    }

    public String toResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : MovingDistance.keySet()) {
            result.append(car.name()).append(" : ");
            result.append("-".repeat(MovingDistance.get(car)));
            result.append("\n");
        }
        return result.toString();
    }

    public String getWinner() {
        int maxDistance = Constant.START_NUM.value;
        for (Car car : MovingDistance.keySet()) {
            if (MovingDistance.get(car) > maxDistance) {
                maxDistance = MovingDistance.get(car);
            }
        }
        StringBuilder winner = new StringBuilder();
        for (Car car : MovingDistance.keySet()) {
            if (MovingDistance.get(car) == maxDistance) {
                winner.append(car.name()).append(", ");
            }
        }
        return winner.substring(Constant.START_NUM.value, winner.length() - Constant.DELETE_LAST_INDEX.value);
    }

    public Map<Car, Integer> getMovingDistance() {
        return MovingDistance;
    }

    enum Constant {
        START_NUM(0),
        DELETE_LAST_INDEX(2);
        private final int value;

        Constant(int value) {
            this.value = value;
        }
    }
}
