package racingcar.domain;

public class Car {

    private static int carNum;

    private final int id;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.id = carNum++;
    }
}
