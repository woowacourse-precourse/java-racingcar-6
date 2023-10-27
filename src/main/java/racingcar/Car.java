package racingcar;

public class Car {
    private final String name;
    private int countMove;
    private static final String MOVE = "-";

    private String totalMove = "";

    public Car(String name) {
        this.name = name;
    }

    public void Move(boolean isMove) {
        System.out.print(name + " : ");
        if (isMove) {
            countMove++;
            totalMove += MOVE;
        }

        System.out.println(totalMove);
    }
}
