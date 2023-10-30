package racingcar.domain;

public class Car {

    public Car(String name) {
        this.name = name;
    }

    private String name;
    private String status;

    public void move() {
        if (isMoveCondition()) {
            // 이동
        }
        printStatus();
    }

    private static boolean isMoveCondition() {

        return false;
    }

    private static void printStatus() {
        printStatus();
    }
}
