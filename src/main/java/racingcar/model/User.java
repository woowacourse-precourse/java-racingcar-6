package racingcar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private boolean isNumber(String size) {
        Pattern pattern = Pattern.compile(NUMBER_REGEXP);
        Matcher matcher = pattern.matcher(size);
        return matcher.matches();
    }

}
