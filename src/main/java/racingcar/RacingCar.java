package racingcar;

public class RacingCar {
    private final String name;
    private int moveCount;

    public RacingCar(String name) {
        validationCarName(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validationCarName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("차량 이름은 1~5의 글자 수만 허용 됩니다.");
        }
    }

    private boolean isValidName(String name) {
        return name.isEmpty() || name.length() > 5;
    }
}
