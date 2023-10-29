package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CarList {

    private final Map<String, Integer> carList;
    private int max = 0;

    public CarList() {
        User user = new User();
        String[] carNameList = user.initCarList();
        carList = new HashMap<>();

        for (String carName : carNameList) {
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

    public int getMax() {
        return max;
    }

    public void moveForward(String carName) {
        int position = carList.get(carName);
        position++;
        carList.put(carName, position);

        if (position > max) {
            max = position;
        }
    }

}
