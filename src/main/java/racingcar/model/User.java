package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.util.Constants.MIN_RANGE;
import static racingcar.util.Constants.MAX_RANGE;
import static racingcar.util.Constants.NUMBER_REGEXP;
import static racingcar.util.VerificationMessage.IS_NOT_NUMBER;

public class User {
    private final int moveSize;

    public User(String size) {
        this.moveSize = moveSize(size);
    }
    public int moveSize(String size) {
        if(!isNumber(size)) throw new IllegalArgumentException(IS_NOT_NUMBER);
        return Integer.parseInt(size);
    }
    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE,MAX_RANGE);
    }
    private boolean isNumber(String size) {
        Pattern pattern = Pattern.compile(NUMBER_REGEXP);
        Matcher matcher = pattern.matcher(size);
        return matcher.matches();
    }

}
