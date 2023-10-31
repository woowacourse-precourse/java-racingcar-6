package racingcar.verification;

import java.util.List;

public class InputVerification {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int CAR_MIN_COUNT = 1;
    private static final String NAME_LENGTH_EXCEPTION = "자동차의 이름은 1자 이상, 5자 이하이어야 합니다.";
    private static final String CAR_COUNT_EXCEPTION = "자동차는 1대 이상이어야 합니다.";
    private static final String NUMBER_TYPE = "숫자만 입력할 수 있습니다.";


    public static void checkAll(String carName) {
        checkCarNameLength(carName);
        checkCarCount(carName);
    }

    private static void checkCarNameLength(String carName) {
        String[] cars = carName.split(",");
        for(int i = 0; i < cars.length; i++) {
            if(cars[i].length() < NAME_MIN_LENGTH || cars[i].length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION);
            }
        }
    }

    private static void checkCarCount(String carName) {
        String[] cars = carName.split(",");
        if(cars.length < CAR_MIN_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEPTION);
        }
    }

    public static void checkInputType(String count) {
        String regex = "[0-9]+";
        if(!count.matches(regex)) {
            throw new IllegalArgumentException(NUMBER_TYPE);
        }
    }
}
