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

    public String getName(int index) {
        return carList.get(index).getName();
    }

    public int getMotionState(int index) {
        return carList.get(index).getMotionState();
    }

    public void setMotionState(int index, int randNumber) {
        carList.get(index).setMotionState(randNumber);
    }


    public int getPosition(int index) {
        return carList.get(index).getPosition();
    }

    public void plusOnePosition(int index) {
        carList.get(index).plusOnePosition();
    }

    public int getSize() {
        return carList.size();
    }


    public int[] findMaxCarPositionIndex() {
        int carPosition;
        int maxCarPosition = -1;
        List<Integer> maxCarPositionIndex = new ArrayList<>();

        for (int index = 0; index < getSize(); index++) {
            carPosition = getPosition(index);
            if (maxCarPosition == carPosition) {
                maxCarPositionIndex.add(index);
            } else if (maxCarPosition < carPosition) {
                maxCarPosition = carPosition;
                maxCarPositionIndex.clear();
                maxCarPositionIndex.add(index);
            }
        }
        return ListToIntArray(maxCarPositionIndex);
    }

    private static int[] ListToIntArray(List<Integer> intList) {
        int[] intArray = new int[intList.size()];
        for (int index = 0; index < intArray.length; index++) {
            intArray[index] = intList.get(index);
        }
        return intArray;
    }

}