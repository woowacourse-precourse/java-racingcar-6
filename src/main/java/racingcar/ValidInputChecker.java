package racingcar;

public class ValidInputChecker {
    private static final String CAR_NAME_LENGHTH_ERROR_MESSAGE = "잘못된 자동차 이름 입니다. 자동차 이름은 5자 이하로 입력해 주세요.";
    private static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "자동차 이름이 존재하지 않습니다. 자동차 이름을 제대로 입력해 주세요.";

    public static void checkCarNameLength(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException(CAR_NAME_LENGHTH_ERROR_MESSAGE);
        }
    }

    public static void checkCarNameIsEmpty(String carName){
        if(carName.equals("")){
            throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
    }
}