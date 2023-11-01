package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.Cars;
import racingcar.view.Try;

public class RaceMap {
    public RaceMap() {
        List<Cars> cars = Cars.make();
        int maxTry = Try.input();


    }
    private int forwardCondition() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random;
    }
}
