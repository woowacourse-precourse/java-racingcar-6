package racingcar.model;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Car> carList;

    public CarList() {
        this.carList = new ArrayList<>();
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void printCarsState() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
}
