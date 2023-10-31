package racingcar.validator;

import racingcar.util.SeparationUtil;

import java.util.Collections;
import java.util.List;

public class InputValidator {

    private static final String INPUT_NUMBER_CORRECT_TYPE = "[0-9]+";
    private static final int INPUT_NAME_MAXIMUM_LENGTH = 5;
    private static final int INPUT_NAME_MINIMUM_LENGTH = 1;

    public void validateInputCarName(String inputCarNames) {
        checkEmptyInput(inputCarNames);
        checkLastCharIsComma(inputCarNames);

        List<String> carNames = SeparationUtil.separationCarName(inputCarNames);
        checkInputCarNameCorrectLength(carNames);
        checkDuplicateCarName(carNames);
        checkCarNameIsBlank(carNames);

    }

    private void checkCarNameIsBlank(List<String> carNames) {
        carNames.forEach(this::checkBlankInput);
    }

    private void checkDuplicateCarName(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (Collections.frequency(carNames, carNames.get(i)) > 1)
                throw new IllegalArgumentException("중복된 차 이름 입니다.");
        }
    }

    private void checkLastCharIsComma(String inputCarNames) {
        if (inputCarNames.charAt(inputCarNames.length() - 1) == ',')
            throw new IllegalArgumentException("쉼표(,)는 이름 구분 용도로 사용해주세요.");
    }

    private void checkEmptyInput(String inputCarNames) {
        if (inputCarNames.isEmpty()) throw new IllegalArgumentException("차 이름을 입력해주세요.");
    }

    private void checkBlankInput(String carName) {
        if (carName.isBlank()) throw new IllegalArgumentException("문자로 된 차 이름을 입력해주세요.");
    }

    public void validateInputNumber(String inputNumber) {
        isInputNumberNotDigit(inputNumber);
    }

    private void checkInputCarNameCorrectLength(List<String> inputCarNames) {
        for (String inputCarName : inputCarNames) {
            if (inputCarName.length() > INPUT_NAME_MAXIMUM_LENGTH)
                throw new IllegalArgumentException("최대 글자수는 " + INPUT_NAME_MAXIMUM_LENGTH + "입니다.");
            if (inputCarName.length() < INPUT_NAME_MINIMUM_LENGTH)
                throw new IllegalArgumentException("최소 글자수는 " + INPUT_NAME_MINIMUM_LENGTH + "입니다.");
        }
    }

    private void isInputNumberNotDigit(String inputNumber) {
        if (!inputNumber.matches(INPUT_NUMBER_CORRECT_TYPE))
            throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
}
