package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameFunction {

    List<Boolean> randomGo(List<String> carList) {
        int numberOfCar = carList.size();
        List<Boolean> carCanGo = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            carCanGo.add(number >= 4);
        }
        return carCanGo;
    }


}
