package racingcar.domain;

import java.util.HashMap;

public class Car {
    private static Car car;
    private int carQuantity;
    private HashMap<String,Integer> carList = new HashMap<String, Integer>();


    public static Car getCar() {
        if(car == null){
            car = new Car();
        }
        return car;
    }

    public int getCarQuantity() {
        return carQuantity;
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }

    public HashMap<String, Integer> getCarList() {
        return carList;
    }

    public void addCarItem(String name) {
            carList.put(name, 0);
    }

    public void updateCarList(String name, int advanceNumber) {
        carList.replace(name,advanceNumber);
    }
}
