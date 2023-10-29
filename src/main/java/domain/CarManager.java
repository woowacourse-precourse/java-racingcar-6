package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private static final int STANDARD_FOR_GO = 4;
    private final List<Car> cars;

    public CarManager() {
        cars = new ArrayList<>();
    }

    CarManager(List<Car> cars) {
        this.cars = cars;
    }

    boolean decideGo(int condition) {
        return condition >= STANDARD_FOR_GO;
    }

    public List<Integer> decideWinner() {
        int max = getMaxPosition();

        List<Integer> winnerIndex = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == max) {
                winnerIndex.add(i);
            }
        }
        return winnerIndex;
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();
    }
}
