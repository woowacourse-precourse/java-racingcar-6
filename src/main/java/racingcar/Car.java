package racingcar;

public class Car {

    private final String name;
    private int countMove;

    private static final String MOVE = "-";

    public Car(String name) {
        this.name = name;
    }

    public void Move(boolean isMove) {
        if (isMove) {
            System.out.print(name + " : ");
            for (int i = 0; i < countMove; i++) {
                System.out.print(MOVE);
            }
            System.out.println();
            countMove++;
        }
    }
}
