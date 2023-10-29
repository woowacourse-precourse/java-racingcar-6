package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int GAME_PROCEED_STANDARD = 4;
    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car nameFrom(String name) {
        return new Car(name, 0);
    }

    private boolean checkProceed() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= GAME_PROCEED_STANDARD;
    }
}
