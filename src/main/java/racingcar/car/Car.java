package racingcar.car;

public class Car {
    public static final int CONDITION_NUM = 4;
    public static final int INIT_NUM = 0;
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = INIT_NUM;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void canMove(int randomNum) {
        if(randomNum >= CONDITION_NUM) {
            plusPosition();
        }
    }

    private void plusPosition() {
        distance++;
    }
}
