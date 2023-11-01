package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private final List<Car> carList;

    @Override
    public Iterator<Car> iterator() {
        return new CarsIterator(carList);
    }

    public Cars(String input) {
        List<Car> list = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (String name : splitInput) {
            list.add(new Car(name));
        }
        this.carList = list;
    }

    public int size() {
        return carList.size();
    }

    private Car getBiggestDistCar() {
        return Collections.max(carList);
    }

    public List<Car> getBiggestDistCars() {
        List<Car> biggestDistCars = new ArrayList<>();
        Car biggestCar = getBiggestDistCar();
        for (Car car : carList) {
            if (biggestCar.compareTo(car) == 0) {
                biggestDistCars.add(car);
            }
        }
        return biggestDistCars;
    }

    private Car getCarAt(int index) {
        return carList.get(index);
    }

    public void moveForwardValueOf(int index) {
        getCarAt(index).moveForward();
    }
}

class CarsIterator implements Iterator<Car> {
    private final List<Car> carList;
    private int index;

    public CarsIterator(List<Car> carList) {
        this.carList = carList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < carList.size();
    }

    @Override
    public Car next() {
        return carList.get(index++);
    }
}