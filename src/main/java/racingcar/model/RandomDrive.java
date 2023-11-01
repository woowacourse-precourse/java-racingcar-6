package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDrive {
    private static final int BOUNDARY_NUMBER = 4;

    public static boolean isDrive() {
        int number = Randoms.pickNumberInRange(1, 9);
        if (number >= BOUNDARY_NUMBER) {
            return true;
        }
        return false;
    }
}
