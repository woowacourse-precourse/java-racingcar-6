package racingcar;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarName(String carNames) {
            checkCarNameLength(carNames);
            checkCarNameBlank(carNames);
    }
    public void checkCarNameLength(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.length() < MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }

            if (name.matches(".*\\d.*")) {
                throw new IllegalArgumentException("자동차 이름에는 정수가 포함되어서는 안됩니다.");
            }
        }
    }

    public void checkCarNameBlank(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 빈 칸은 포함될 수 없습니다.");
        }
    }

    public void checkRoundNumberBlank(String round) {
        if (round.contains(" "))
            throw new IllegalArgumentException("게임 시도 회수에 빈 칸은 포함될 수 없습니다.");
    }
}
