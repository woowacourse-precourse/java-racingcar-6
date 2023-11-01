package racingcar.model;

import racingcar.Constants;
import racingcar.Utils;

import java.util.ArrayList;

public class CarNameValidator {
    private final String NAMES_STRING;
    public final ArrayList<String> NAMES;

    public CarNameValidator(String namesString) {
        this.NAMES_STRING = namesString;
        this.NAMES = Utils.toArrayList(namesString);
        validate();
    }
    public void validate() {

    }
    public void isRightNamesString() {
        // String 형식 확인 : 앞&뒤-문자, 중간-문자&구분자
        if (!Constants.nameStringPattern.matcher(NAMES_STRING).matches()) {
            throw new IllegalArgumentException(Constants.CAR_NAME_WRONG_ERROR);
        }
    }
    public void isRightNameSize() {
        if (NAMES.stream().anyMatch(name -> name.isEmpty() || name.length() > Constants.NAME_SIZE)) {
            throw new IllegalArgumentException(Constants.CAR_NAME_SIZE_ERROR);
        }
    }
}
