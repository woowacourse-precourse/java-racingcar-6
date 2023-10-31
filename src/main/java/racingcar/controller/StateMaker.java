package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Racer;

public class StateMaker {

    public static Racer getGoOrStop(Racer racer) {
        if (decideGoOrStop() == true){
            racer.goState();
        } else {
            racer.stopState();
        }
        return racer;
    }

    private static boolean decideGoOrStop() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
