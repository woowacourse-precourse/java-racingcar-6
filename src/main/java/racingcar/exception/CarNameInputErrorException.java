package racingcar.exception;

import java.util.List;

public class CarNameInputErrorException implements InputErrorException{
    private final static int CAR_NAME_LEGTH_MIN_RANGE = 1;
    private final static int CAR_NAME_LEGTH_MAX_RANGE = 5;
    private final static String CAR_NAME_LENGTH_SHORT_MESSAGE = "각 자동차 이름은 1글자 이상 입력해주세요.";
    private final static String CAR_NAME_LENGTH_LONG_MESSAGE = "각 자동차 이름은 5글자 이하로 입력해주세요.";
    private final static String CAR_NAME_LIST_EMPTY_MESSAGE = "각 자동차 이름을 ,로 구분해서 입력해주세요.";

    @Override
    public void checkUserInputValidate(List<String> checkStringList) {
        if(isStringListEmpty(checkStringList)){
            throw new IllegalArgumentException(CAR_NAME_LIST_EMPTY_MESSAGE);
        }
        checkStringList.forEach(checkString -> {
            if (isCarNameShorterThanMinLength(checkString)) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_SHORT_MESSAGE);
            } else if (isCarNameLongerThanMaxLength(checkString)) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_LONG_MESSAGE);
            }
        });
    }

    private static boolean isStringListEmpty(List<String> checkStringList){
        return checkStringList.isEmpty();
    }
    private static boolean isCarNameShorterThanMinLength(String checkString){
        return checkString.length() < CAR_NAME_LEGTH_MIN_RANGE;
    }

    private static boolean isCarNameLongerThanMaxLength(String checkString){
        return checkString.length() > CAR_NAME_LEGTH_MAX_RANGE;
    }
}
