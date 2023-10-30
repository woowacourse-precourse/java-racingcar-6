package racingcar.service;

import racingcar.exception.NotValidInputException;

import java.util.regex.Pattern;

import static racingcar.util.GameCondition.*;

// 사용자가 입력한 값의 유효성을 판단하는 클래스
public class InputService {
    private final static String REGEXP_PATTERN_NUMBER = "[0-9]"; // 숫자만 입력 가능

    public void checkCarNameValidation(String carName) {
        checkBlankValidation(carName, "자동차의 이름은 공백이 될 수 없습니다."); // 공백 확인
        checkLengthValidation(carName); // 자동차의 이름 길이 제약 조건 확인
    }

    public void checkCompetitionNumberValidation(String competition) {
        checkBlankValidation(competition, "사용자의 입력은 공백이 될 수 없습니다."); // 공백 확인
        checkNumberPatternValidation(competition); // 입력한 횟수가 숫자인지 확인
    }

    private void checkBlankValidation(String carName, String message) {
        if(carName.isBlank() || carName.isEmpty())
            throw new NotValidInputException(message);
    }

    private void checkLengthValidation(String carName) {
        int length = carName.length();

        if(length > CONDITION_INPUT_MAX_LENGTH.getCondition() || length < CONDITION_INPUT_MIN_LENGTH.getCondition())
            throw new NotValidInputException("자동차의 이름은 최소 1자 이상, 5자 이하이어야 합니다.");
    }

    private void checkNumberPatternValidation(String competition) {
        if(!Pattern.matches(REGEXP_PATTERN_NUMBER, competition))
            throw new NotValidInputException("이동 횟수는 숫자만 입력할 수 있습니다.");
    }
}