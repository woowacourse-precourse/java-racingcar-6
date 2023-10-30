package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public void moveForward(int distance) {
        position += distance;
    }
}
