package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    Cars(List<String> names) {
        List<Car> newCarList = new ArrayList<>();
        for (String name : names) {
            newCarList.add(new Car(name));
        }
        carList = Collections.unmodifiableList(newCarList);
    }

    Cars(List<String> names, List<Integer> position) {
        List<Car> newCarList = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            newCarList.add(new Car(names.get(i), position.get(i)));
        }
        carList = Collections.unmodifiableList(newCarList);
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
