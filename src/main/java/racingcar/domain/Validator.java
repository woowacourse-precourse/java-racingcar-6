package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private final int MAX_CAR_LENGTH = 5;
    private final int MIN_CAR_NUMBER = 2;
    private final int MIN_ROUND_NUMBER = 1;

    public Validator() {
    }

    public void validateCarNames(List<String> carNames) throws IllegalArgumentException {
        if (existsDuplicateName(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
        if (isBiggerThanMaxCarLength(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
        if (isSmallerThanMinCarNumber(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 개수는 2개 이상여야 합니다.");
        }
    }

    public void validateRounds(String userInput) throws IllegalArgumentException {
        if (isNotNumber(userInput) || isSmallerThanMinRoundNumber(userInput)) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 숫자를 입력해주세요.");
        }
    }

    public boolean existsDuplicateName(List<String> carNames) {
        Set<String> deduplication = new HashSet<>(carNames);
        if (carNames.size() == deduplication.size()) {
            return false;
        }
        return true;
    }

    public boolean isBiggerThanMaxCarLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_LENGTH) {
                return true;
            }
        }
        return false;
    }

    public boolean isSmallerThanMinCarNumber(List<String> carNames) {
        if (carNames.size() < MIN_CAR_NUMBER) {
            return true;
        }
        return false;
    }

    public boolean isNotNumber(String rounds) {
        try {
            Integer.valueOf(rounds);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public boolean isSmallerThanMinRoundNumber(String rounds) {
        if (Integer.valueOf(rounds) < MIN_ROUND_NUMBER) {
            return true;
        }
        return false;
    }

}
