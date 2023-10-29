package racingcar;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String GAME_COUNT_FORMAT = "[0-9]+";

    private final Race race;

    public InputValidator(Race race) {
        this.race = race;
    }

    public void carName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 다섯 글자 이하이어야 합니다.");
        }
        if (race.hasDuplicatedCarNames(carName)) {
            throw new IllegalArgumentException("자동차 이름이 중복되어서는 안 됩니다.");
        }
    }

    public void gameCount(String gameCount) {
        if (!gameCount.matches(GAME_COUNT_FORMAT)) {
            throw new IllegalArgumentException("올바른 형식의 숫자를 입력해주세요.");
        }
    }
}
