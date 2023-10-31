package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    Cars(List<String> names) {
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    Cars(List<String> names, List<Integer> position) {
        for (int i = 0; i < names.size(); i++) {
            carList.add(new Car(names.get(i), position.get(i)));
        }
    }

    public int size() {
        return carList.size();
    }

    public void go(int index) {
        carList.get(index).go();
    }

    public void stop(int index) {
        carList.get(index).stop();
    }

    public Car getCar(int index) {
        Car car = carList.get(index);
        return new Car(car.getName(), car.getPosition());
    }

    public List<Car> getAll() {
        return new ArrayList<>(carList);
    }

    public int getPosition(int index) {
        return carList.get(index).getPosition();
    }

    public int getMaxPosition() {
        return carList.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();
    }
}
