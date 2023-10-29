package racingcar;

import java.util.HashMap;
import java.util.Map;

public class CarList {

    private final User user;
    private final Map<String, Integer> carList;

    public CarList() {
        user = new User();
        String[] carNameList = user.initCarList();
        carList = new HashMap<>();

        for (String carName : carNameList) {
            carList.put(carName, 0);
        }
    }

    public Map<String, Integer> getCarList() {
        return carList;
    }

    public void moveForward(String carName) {
        int position = carList.get(carName);
        position++;
        carList.put(carName, position);
    }

}
