package racingcar.controller;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.AllPunctuationMarks.SPACE;
import static racingcar.constant.AllPunctuationMarks.COMMA;
import static racingcar.constant.ExceptionMessage.*;

import java.util.Map;

public class Validation {

    public void checkNameInputCommaOrSpace(String carNameInput) { // 입력된 문자열 전체에 관한 유효성 검사
        if (carNameInput.contains(COMMA)) {
            checkComma(carNameInput);
        }
        if (carNameInput.contains(SPACE)) {
            checkSpace(carNameInput);
        }
    }

    private void checkComma(String carNameInput) { // 자동차 이름 입력 시 쉼표가 포함되면 수행하는 유효성 검사
        checkFirstOrLastComma(carNameInput);
        checkContinuousComma(carNameInput);
    }
    private void checkFirstOrLastComma(String carNameInput) {
        int lastIndex = carNameInput.length() - 1;
        if (carNameInput.charAt(0) == COMMA.charAt(0) || carNameInput.charAt(lastIndex) == COMMA.charAt(0)) {
            throw new IllegalArgumentException(NULL_CAR_NAME + carNameInput);
        }
    }
    private void checkContinuousComma(String carNameInput) {
        if (carNameInput.contains(COMMA + COMMA)) {
            throw new IllegalArgumentException(NULL_CAR_NAME + carNameInput);
        }
    }

    private void checkSpace(String carNameInput) { // 자동차 이름에 공백문자 포함 시 수행하는 유효성 검사
        checkFirstOrLastSpace(carNameInput);
        checkContinuousSpace(carNameInput);
    }
    private void checkFirstOrLastSpace(String carNameInput) {
        int lastIndex = carNameInput.length() - 1;
        if (carNameInput.charAt(0) == SPACE.charAt(0) || carNameInput.charAt(lastIndex) == SPACE.charAt(0)) {
            throw new IllegalArgumentException(SPACE_IN_CAR_NAME + carNameInput);
        }
        if (carNameInput.contains(COMMA + SPACE) || carNameInput.contains(SPACE + COMMA)) {
            throw new IllegalArgumentException(SPACE_IN_CAR_NAME + carNameInput);
        }
    }
    private void checkContinuousSpace(String carNameInput) {
        if (carNameInput.contains(SPACE + SPACE)) {
            throw new IllegalArgumentException(SPACE_IN_CAR_NAME + carNameInput);
        }
    }

    public void checkNameTokenLengthOver(String carNameToken) { // 1개의 자동차 이름 길이에 관한 유효성 검사
        if (carNameToken.length() > MAX_NAME_TOKEN_LENGTH) {
            throw new IllegalArgumentException(OVER_CAR_NAME_LIMIT + carNameToken);
        }
    }

    // 현재 자동차 이름의 중복 여부에 관한 유효성 검사
    public void checkNameTokenDuplicated(String carNameToken, Map<String, Integer> carList) {
        if (carList.containsKey(carNameToken)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED + carNameToken);
        }
    }

    public void checkRoundsNumeric(String round) {  // 입력된 라운드수가 유효한 정수값인지 검사
        try {
            int temp = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ROUNDS + round);
        }
    }

    public void checkRoundsZeroOrNegative(int rounds) { // 정수로 변환된 라운드수가 양의 정수인지, 0인지, 음의 정수인지 검사
        if (rounds <= 0) {
            throw new IllegalArgumentException(ZERO_ROUNDS);
        }
    }
}