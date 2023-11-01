package racingcar.domain;

public class Car {

    private String name;
    private Integer moves = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getMoves() {
        return moves;
    }

    public void move() {
        moves += 1;
    }
}
