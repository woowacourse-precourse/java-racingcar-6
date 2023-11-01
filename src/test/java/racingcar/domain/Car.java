package racingcar.domain;

public class Car {

    public Car(String name, Integer moves) {
        this.name = name;
        this.moves = moves;
    }

    private String name;
    private Integer moves = 0;
}
