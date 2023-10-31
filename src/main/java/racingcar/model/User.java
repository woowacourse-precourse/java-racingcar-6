package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.util.Constants.MIN_RANGE;
import static racingcar.util.Constants.MAX_RANGE;
import static racingcar.util.Constants.NUMBER_REGEXP;
import static racingcar.util.Constants.MOVE_FORWARD;
import static racingcar.util.Constants.INIT;
import static racingcar.util.VerificationMessage.IS_NOT_NUMBER;
import static racingcar.util.VerificationMessage.NOT_ZERO;
import static racingcar.util.VerificationMessage.NOT_NEGATIVE_NUMBER;

public class User {
    private final int moveSize;

    public User(String size) {
        this.moveSize = moveSize(size);
    }
    public int moveSize(String size) {
        if(!isNumber(size)) {
            try {
                if (isNegativeNumber(size)) throw new IllegalArgumentException(NOT_NEGATIVE_NUMBER);
            }catch(NumberFormatException e) {
                throw new IllegalArgumentException(IS_NOT_NUMBER);
            }
        }
        if(isZero(size)) throw new IllegalArgumentException(NOT_ZERO);

        return Integer.parseInt(size);
    }
    public boolean moveForward() {
        return createRandomNumber() >= MOVE_FORWARD;
    }
    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE,MAX_RANGE);
    }
    private boolean isNumber(String size) {
        Pattern pattern = Pattern.compile(NUMBER_REGEXP);
        Matcher matcher = pattern.matcher(size);
        return matcher.matches();
    }
    private boolean isZero(String size) {
        return Integer.parseInt(size) == INIT;
    }
    private boolean isNegativeNumber(String size) {
        return Integer.parseInt(size) < INIT;
    }
    public int getMoveSize() {
        return this.moveSize;
    }
}
