package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class Game {


    public List<String> splitCarName(String carName) {
        List<String> carNameList = new ArrayList<>();
        String[] carNames = carName.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNameList.add(carNames[i]);
        }

        return carNameList;
    }


    public int createCarNumber() {
        int carNumber = Randoms.pickNumberInRange(0, 9);
        return carNumber;
    }
}
