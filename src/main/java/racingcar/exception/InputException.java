package racingcar.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputException {
    public void checkCarNamesInputException(ArrayList<String> carNames) {

        checkCarNameLength(carNames);
        checkDuplication(carNames);
        checkEmpty(carNames);

    }

    public void checkAttemptsInputException(int attemptsCount) {
        checkIsNotZero(attemptsCount);
    }

    private void checkIsNotZero(int attemptsCount) {
        if (attemptsCount < 1) {
            throw new IllegalArgumentException("시도 회수는 1 이상이여야 합니다");
        }
    }

    private void checkCarNameLength(ArrayList<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() >= 6) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력하세요");
            }
        }
    }

    private void checkDuplication(ArrayList<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() != carNamesSet.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 불가합니다.");

        }

    }

    private void checkEmpty(ArrayList<String> carNames) {

        for (String carname : carNames) {
            if (carname.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 불가합니다.");

            }
        }

    }

}
