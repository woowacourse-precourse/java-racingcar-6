package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputViewValidator {

    private static final Integer MAX_CAR_NAME_LENGTH = 5;
    private static final Integer MINIMUM_POSITIVE_LIMIT = 0;
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";
    private static final String STRING_EMPTY_ERROR_MESSAGE = "";
    private static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "";
    private static final String INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE = "";
    private static final String DUPLICATE_CAR_NAME_EXISTS_ERROR_MESSAGE = "";
    private static final String PARSE_INT_FAILURE_ERROR_MESSAGE = "";
    private static final String INVALID_INTEGER_RANGE_ERROR_MESSAGE = "";



    public void validateCarNames(String carNamesString){
        if(isStringEmpty(carNamesString)) throw new IllegalArgumentException(STRING_EMPTY_ERROR_MESSAGE);

        List<String> carNameList = Arrays.asList(carNamesString.split(COMMA));
        for (String carName : carNameList){
            if (isCarNameEmpty(carName)) throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE);
            if (isInvalidCarNameLength(carName)) throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
        if (duplicateCarNameExists(carNameList)) throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXISTS_ERROR_MESSAGE);
    }

    public void validateTotalRoundNumber(String totalRoundNumberString){
        if (isStringEmpty(totalRoundNumberString)) throw new IllegalArgumentException(STRING_EMPTY_ERROR_MESSAGE);
        Integer totalRoundNumber = tryParseInt(totalRoundNumberString);
        if (isInvalidIntegerRange(totalRoundNumber)) throw new IllegalArgumentException(INVALID_INTEGER_RANGE_ERROR_MESSAGE);
    }

    private Boolean isStringEmpty(String string){
        if(string.equals(EMPTY_STRING)) return true;
        return false;
    }

    private Integer tryParseInt(String string) throws IllegalArgumentException{
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(PARSE_INT_FAILURE_ERROR_MESSAGE);
        }
    }

    private Boolean isCarNameEmpty(String carName){
        if(carName.equals(EMPTY_STRING)) return true;
        return false;
    }

    private Boolean isInvalidCarNameLength(String carName){
        if(carName.length() > MAX_CAR_NAME_LENGTH) return true;
        return false;
    }

    private Boolean duplicateCarNameExists(List<String> carNameList){
        List<String> distinctCarNameList = carNameList.stream()
                .distinct()
                .collect(Collectors.toList());
        if (carNameList.size() != distinctCarNameList.size()) return true;
        return false;
    }

    private Boolean isInvalidIntegerRange(Integer integer){
        if (integer < MINIMUM_POSITIVE_LIMIT) return true;
        return false;
    }
}
/*
* 자동차 이름들(carNameList)은 쉼표(,)를 기준으로 구분되어야 한다.
자동차 이름(Car.name)은
빈 칸이면 안된다.
5자 이하만 가능하다.
중복된 이름이 있어선 안된다.
*
*
라운드 수(InputTotalRoundNumber)
총 round 수는
빈 칸이면 안된다.
음수가 아닌 정수 타입이어야 한다.
범위를 초과하는 큰값이면 안된다.
*/