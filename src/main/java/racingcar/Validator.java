package racingcar;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarName(String carNames) {
        try {
            checkCarNameLength(carNames);
            checkCarNameBlank(carNames);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void checkCarNameLength(String carNames) {
        int length = carNames.split(",").length;
        if (length < MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
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
