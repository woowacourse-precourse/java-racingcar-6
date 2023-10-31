package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.MessageFormat;

public class Racer {
    private final String name;
    private String distance = "";
    private static final int MOVING_FORWARD = 4;

    public Racer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null Input (racer)");
        }
        this.name = name;
    }

    public void proceedTurn() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVING_FORWARD) {
            this.distance = this.distance + "-";
        }
        String printString = MessageFormat.format("{0} : {1}", name, distance);
        System.out.println(printString);
    }
}
