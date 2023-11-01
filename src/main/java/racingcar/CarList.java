package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CarList {

    private final Map<String, Integer> carList;

    public CarList(String[] carArray) {
        carList = new HashMap<>();

        for (String carName : carArray) {
            checkList(carName);
            carList.put(carName, 0);
        }
    }

    public String[] getCarNameList() {
        Set<String> keySet = carList.keySet();
        int arrSize = carList.size();
        return keySet.toArray(new String[arrSize]);
    }

    public int getPosition(String carName) {
        return carList.get(carName);
    }

    public void moveForward(String carName) {
        int position = carList.get(carName);
        position++;
        carList.put(carName, position);
    }

    private void checkList(String carName) {
        if (carList.containsKey(carName)) {
            throw new IllegalArgumentException();
        }
    }

}
