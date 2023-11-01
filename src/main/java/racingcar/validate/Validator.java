package racingcar.validate;

import java.util.ArrayList;
import java.util.List;
import racingcar.Constants;

public class Validator {
    public static void ValidateRightNamesString(String nameString) {
        if (!Constants.nameStringPattern.matcher(nameString).matches()) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_LIST);
        }
    }

    public static void ValidateRightNameSize(List<String> nameList) {
        if (nameList.stream().anyMatch(name -> name.isEmpty() || name.length() > Constants.NAME_SIZE)) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAME_SIZE);
        }
    }

    public static void ValidateDuplicate(List<String> nameList) {
        if (nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAME_DUPLICATE);
        }
    }

    public static void ValidateRoundNumberType(String roundNumberString){
        if(!Constants.roundNumberPattern.matcher(roundNumberString).matches()){
            throw new IllegalArgumentException(Constants.INVALID_ROUND_NUM);
        }
    }
}
