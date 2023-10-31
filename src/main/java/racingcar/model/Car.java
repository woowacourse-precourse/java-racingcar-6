package racingcar.model;

public final class Car{
    private static final int INITIAL_PROGRESS = 0;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private final int progress;

    private Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public static Car from(String name) {
        return new Car(name, INITIAL_PROGRESS);
    }

    public Car move(int randomNumber) {
        if(randomNumber < MIN_RANDOM_NUMBER || randomNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException("0~9사이의 수만 입력 받을 수 있습니다.");
        }
        if(isMoved(randomNumber)) {
            return new Car(this.name, this.progress + 1);
        }
        return new Car(this.name, this.progress);
    }

    private boolean isMoved(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }
}
