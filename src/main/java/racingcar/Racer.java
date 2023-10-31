package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.MessageFormat;

public class Racer {
    private static final int MOVING_FORWARD = 4;
    private static final String RACING_DISPLAY = "-";

    private final String name;
    private String distance = "";

    public Racer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null Input (racer)");
        }
        this.name = name;
    }

    public void proceedTurn() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVING_FORWARD) {
            this.distance = this.distance + RACING_DISPLAY;
        }
        String printString = MessageFormat.format("{0} : {1}", name, distance);
        System.out.println(printString);
    }
}
