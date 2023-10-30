package domain;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private static final int STANDARD_FOR_GO = 4;
    private final List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
    }

    CarService(List<Car> cars) {
        this.cars = cars;
    }

    private void add(String name) {
        cars.add(new Car(name));
    }

    public void add(List<String> names) {
        names.forEach(this::add);
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
