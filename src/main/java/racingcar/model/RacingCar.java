package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameMessage;

public class RacingCar {
    public static final Integer MIN_RANDOM_NUMBER = 1;
    public static final Integer MAX_RANDOM_NUMBER = 9;
    public static final Integer ADVANCE_THRESHOLD = 4;
    private final String racingCarName;
    private String advanceMarking;

    public RacingCar(String racingCarName) {
        this.racingCarName = racingCarName;
        this.advanceMarking = "";
    }
    public void advance() {
        this.advanceMarking += GameMessage.ADVANCE_MARK;
    }
    public boolean canAdvance() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNumber >= ADVANCE_THRESHOLD;
    }
    public String getAdvanceMarking() {
        return advanceMarking;
    }
    public String getRacingCarName() {
        return racingCarName;
    }
}