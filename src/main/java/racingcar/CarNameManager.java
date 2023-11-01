package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameManager {

    private List<String> carNameList;

    public CarNameManager() {
        carNameList = new ArrayList<>();
    }

    public void splitCarName(String carName) {
        String[] carNameArray = carName.split(",");

        for (int i = 0; i < carNameArray.length; i++) {
            carNameList.add(carNameArray[i]);
        }
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
