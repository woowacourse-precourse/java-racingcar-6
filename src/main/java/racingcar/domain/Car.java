package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int INITIAL_PROGRESS_COUNT = 0;
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVE_FORWARD_MINIMUM_NUM = 4;

    private String name;
    private int progressCount;

    public Car(String name) {
        validateBlankName(name);
        validateNameLength(name);
        this.name = name;
        progressCount = INITIAL_PROGRESS_COUNT;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int randomNum) {
        if (isMoveForward(randomNum)) {
            moveForward();
        }
    }

    private boolean isMoveForward(int randomNum) {
        return randomNum >= MOVE_FORWARD_MINIMUM_NUM;
    }

    private void moveForward() {
        progressCount++;
    }

    public boolean isSameProgress(Car car) {
        return car.progressCount == progressCount;
    }

    @Override
    public int compareTo(Car car) {
        return car.progressCount - progressCount;
    }

    public String getName() {
        return name;
    }

    public int getProgressCount() {
        return progressCount;
    }
}
