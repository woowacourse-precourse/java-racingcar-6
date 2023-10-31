package racingcar.service;

import racingcar.exception.NotValidInputException;

import java.util.regex.Pattern;

import static racingcar.exception.GameExceptionMessage.*;

// 사용자가 입력한 값의 유효성을 판단하는 클래스
public class InputService {
    private final static String REGEXP_PATTERN_NUMBER = "^[0-9]*$"; // 숫자만 입력 가능
    private final static int INPUT_MAX_LENGTH = 5;
    private final static int INPUT_MIN_LENGTH = 1;

    public void checkCarNameValidation(String carName) {
        checkBlankValidation(carName, CAR_NAME_CAN_NOT_BE_BLANK.getMessage()); // 공백 확인
        checkLengthValidation(carName); // 자동차의 이름 길이 제약 조건 확인
    }

    public void checkFrequencyValidation(String competition) {
        checkBlankValidation(competition, USER_INPUT_CAN_NOT_BE_BLANK.getMessage()); // 공백 확인
        checkNumberPatternValidation(competition); // 입력한 횟수가 숫자인지 확인
    }

    private void checkBlankValidation(String carName, String message) {
        if(carName.isBlank() || carName.isEmpty())
            throw new NotValidInputException(message);
    }

    private void checkLengthValidation(String carName) {
        int length = carName.length();

        if(length > INPUT_MAX_LENGTH || length < INPUT_MIN_LENGTH)
            throw new NotValidInputException(CAR_NAME_LENGTH.getMessage());
    }

    private void checkNumberPatternValidation(String competition) {
        if(!Pattern.matches(REGEXP_PATTERN_NUMBER, competition))
            throw new NotValidInputException(FREQUENCY_ONLY_NUMBER.getMessage());
    }
}