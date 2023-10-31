package model;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Car> carList;

    public CarList() {
        this.carList = new ArrayList<Car>();
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
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }
        System.out.println();
    }
}
