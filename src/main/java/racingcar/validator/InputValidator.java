package racingcar.validator;

public class InputValidator {
    public void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }

    public void validateRoundCount(String roundCount) {
        try {
            int rounds = Integer.parseInt(roundCount);
            if (rounds <= 0) {
                throw new IllegalArgumentException("라운드 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 횟수는 숫자여야 합니다.");
        }
    }
}
