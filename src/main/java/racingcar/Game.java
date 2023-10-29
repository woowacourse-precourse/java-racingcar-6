package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    public static void forwardOrStop(List<Car> cars) {
        for (Car present : cars) {
            Integer randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                present.addScore();
            }
        }
    }
}
