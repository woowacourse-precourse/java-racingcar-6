package racingcar.service.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {
    public static boolean isMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
    public static void moveCars(int[] countsByName) {
        for(int t = 0; t < countsByName.length; t++) {
            if(isMoveForward()) {
                countsByName[t]++;
            }
        }
    }
}
