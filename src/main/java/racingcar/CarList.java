package racingcar;

import java.util.HashMap;
import java.util.Map;

public class CarList {

    User user;
    Map<String, Integer> carList;

    public CarList() {
        user = new User();
        String[] carNameList = user.initCarList();
        carList = new HashMap<>();

        for (String carName : carNameList) {
            carList.put(carName, 0);
        }
    }

}
