package racingcar.model;

public final class Car{
    private final String name;
    private final int progress;

    private Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public static Car from(String name) {
        return new Car(name, 0);
    }

    public Car move(int randomNumber) {
        if(randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException("0~9사이의 수만 입력 받을 수 있습니다.");
        }
        if(isMoved(randomNumber)) {
            return new Car(this.name, this.progress + 1);
        }
        return new Car(this.name, this.progress);
    }

    private boolean isMoved(int number) {
        return number >= 4;
    }

    public int getProgress() {
        return progress;
    }
}
