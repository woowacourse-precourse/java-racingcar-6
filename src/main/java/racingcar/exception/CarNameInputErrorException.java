package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInputErrorException implements InputErrorException{
    private final static int CAR_NAME_LEGTH_MIN_RANGE = 1;
    private final static int CAR_NAME_LEGTH_MAX_RANGE = 5;
    private final static String CAR_NAME_LENGTH_SHORT_MESSAGE = "각 자동차 이름은 1글자 이상 입력해야합니다. 게임을 종료합니다.";
    private final static String CAR_NAME_LENGTH_LONG_MESSAGE = "각 자동차 이름은 5글자 이하로 입력해야합니다. 게임을 종료합니다.";
    private final static String CAR_NAME_LIST_EMPTY_MESSAGE = "자동차 이름은 필수로 입력해야합니다. 게임을 종료합니다.";
    private final static String CAR_NAME_DUPLICATE_MESSAGE = "중복된 자동차 이름이 존재합니다. 게임을 종료합니다.";

    @Override
    public void checkUserInputValidate(List<String> checkStringList) {
        if(isStringListEmpty(checkStringList)){
            throw new IllegalArgumentException(CAR_NAME_LIST_EMPTY_MESSAGE);
        }
        if(isCarNameDuplicate(checkStringList)){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_MESSAGE);
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
    private static boolean isCarNameDuplicate(List<String> checkStringList){
        Set<String> stringSet = new HashSet<>(checkStringList);
        return stringSet.size() == checkStringList.size();
    }
    private static boolean isCarNameShorterThanMinLength(String checkString){
        return checkString.length() < CAR_NAME_LEGTH_MIN_RANGE;
    }

    private static boolean isCarNameLongerThanMaxLength(String checkString){
        return checkString.length() > CAR_NAME_LEGTH_MAX_RANGE;
    }
}
