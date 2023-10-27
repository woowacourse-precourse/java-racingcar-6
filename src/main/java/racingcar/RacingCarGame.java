package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<String> carNameList;

    public RacingCarGame() {
        carNameList = new ArrayList<>();
    }

    public void splitCarName(String carName) {
        String[] carNameArray = carName.split(",");

        for (int i = 0; i < carNameArray.length; i++) {
            carNameList.add(carNameArray[i]);
        }
    }
}
