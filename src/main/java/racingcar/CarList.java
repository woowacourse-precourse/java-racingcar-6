package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(String carsName) throws IllegalArgumentException {
        String[] names = splitNamesByComma(carsName);
        if (!isBlankSpace(carsName) || !isValidNameLength(names) || isDuplicatedName(names)) {
            throw new IllegalArgumentException();
        }
        this.carList = new ArrayList<>();
        setCarIntoCarList(names);
    }

    private String[] splitNamesByComma(String name) {
        return name.split(",");
    }

    private boolean isValidNameLength(String[] names) {
        for (String name : names) {
            if (name.length() == 0 || name.length() >= 6) {
                return false;
            }
        }
        return true;
    }

    private boolean isBlankSpace(String names) {
        if (names.contains(" ")) {
            return false;
        }
        return true;
    }

    private boolean isDuplicatedName(String[] names) {
        HashSet<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (nameSet.contains(name)) {
                return true;
            }
            nameSet.add(name);
        }
        return false;
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