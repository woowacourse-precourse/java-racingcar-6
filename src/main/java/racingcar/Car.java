package racingcar;

public class Car {
    private final String name;
    private static final String MOVE = "-";
    private String totalMove = "";
    private static final int LIMIT_NAME_LEN = 5;

    public Car(String name) {
        this.name = name;
        validateCarName();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalMove() {
        return totalMove.length();
    }

    public void validateCarName() {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_NAME_ERROR_MESSAGE);
        }
        if (name.length() > LIMIT_NAME_LEN) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public void moveOrStop(boolean isMove) {
        System.out.print(name + " : ");
        if (isMove) {
            totalMove += MOVE;
        }

        System.out.println(totalMove);
    }
}
