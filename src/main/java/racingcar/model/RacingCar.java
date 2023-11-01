package racingcar.model;

public class RacingCar {
    private static final String NAME_LENGTH_VALIDATE = "이름은 1자 이상 5자 이하만 가능합니다.";
    private static final int MOVE_STANDARD = 4;
    private static final String COLON = ":";
    private static final String MOVE_COUNT_STRING = "-";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int moveCount;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(NAME_LENGTH_VALIDATE);
    }

    public String getRacingCarName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void move(int number) {
        if (number >= MOVE_STANDARD)  this.moveCount ++;
    }

    public String getPresentStatus() {
        return this.name + COLON + MOVE_COUNT_STRING.repeat(this.moveCount);
    }

    public boolean isWinnerRacingCar(int maxMoveCount) {
        return this.moveCount == maxMoveCount;
    }
}
