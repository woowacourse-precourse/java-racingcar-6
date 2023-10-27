package model;

public class Car implements Comparable<Car> {
    private final Name name;
    private final MovingCount movingCount;
    private static final int MAX_LENGTH = 5;
    private static final String DASH = "-";
    private static final String COLON = ":";
    private static final String SPACE = " ";
    private static final String TOO_LONG_NAME = "이름은 %d글자 미만이어야 합니다.";

    public Car(String name) {
        this.name = new Name(name);
        this.movingCount = new MovingCount();
    }

    public boolean isSameMovingCount(Car otherCar) {
        return this.movingCount.equals(otherCar.movingCount);
    }

    public void increaseMovingCountIfGreater(int number, int randomNumber) {
        if (randomNumber >= number) {
            this.movingCount.increase();
        }
    }

    public String currentRacingStatus() {
        String moveDash = DASH.repeat(movingCount.getMovingCount());
        return this + SPACE + COLON + SPACE + moveDash;
    }

    @Override
    public int compareTo(Car otherCar) {
        int otherMovingCount = otherCar.movingCount.getMovingCount();
        int currentMovingCount = this.movingCount.getMovingCount();
        return otherMovingCount - currentMovingCount;
    }

    @Override
    public String toString() {
        return this.name.getName();
    }

    private static void validateNameLength(String name) {
        if (isNameTooLong(name)) {
            throw new IllegalArgumentException(String.format(TOO_LONG_NAME, MAX_LENGTH));
        }
    }

    private static boolean isNameTooLong(String name) {
        return name.length() >= MAX_LENGTH;
    }
}
