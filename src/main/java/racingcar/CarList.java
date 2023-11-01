package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(String[] names) {
        this.carList = new ArrayList<>();
        setCarIntoCarList(names);
    }


    private void setCarIntoCarList(String[] names) {
        for (String name : names) {
            this.carList.add(new Car(name));
        }
    }

    public int getSize() {
        return carList.size();
    }

    public void setMotionState(int index, int randNumber) {
        Car car = carList.get(index);
        car.setMotionState(randNumber);
    }

    public void plusOnePosition(int index) {
        Car car = carList.get(index);
        car.plusOnePosition();
    }

    public int getMotionState(int index) {
        Car car = carList.get(index);
        return car.getMotionState();
    }

    public String getName(int index) {
        return carList.get(index).getName();
    }

    public int getPosition(int index) {
        return carList.get(index).getPosition();
    }

}