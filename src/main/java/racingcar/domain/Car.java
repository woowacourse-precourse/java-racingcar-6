package racingcar.domain;

public class Car {

    private static int carNum;

    private final int id;
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        this.id = carNum++;
    }
}
