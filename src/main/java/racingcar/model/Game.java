package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class Game {


    public String[] splitCarName(String carNames) {
        return carNames.split(",");
    }


    public int createCarNumber() {
        int carNumber = Randoms.pickNumberInRange(0, 9);
        return carNumber;
    }
}
