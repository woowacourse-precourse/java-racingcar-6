package racingcar.util;

import static racingcar.AppConfig.MAX_CARNAME_LENGTH;

public class WrongChecker {

    public void hasWrongCarName(String target) {
        String[] checkArray = target.split(",");
        for (String s : checkArray) {
            if (s.length() > MAX_CARNAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void hasWrongAttemptNum(String target) {
        for (int i = 0; i < target.length(); i++) {
            if (!(target.charAt(i) >= '0' && target.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
        }
    }
}