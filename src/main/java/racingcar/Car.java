package racingcar;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // 이동 -> 네이밍을 어떻게 할까? -> move(),
    public void move() {
        if (RandomNumberGenerator.generateNumber() >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
