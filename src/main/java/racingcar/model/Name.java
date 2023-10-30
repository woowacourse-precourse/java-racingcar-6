package racingcar.model;

import java.util.List;

public class Name {

    public static final int CAR_NAME_LENGTH = 5;

    public void isValid(List<String> playerNames) {
        for (String playerName : playerNames) {
            if (playerName.length() > CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
}