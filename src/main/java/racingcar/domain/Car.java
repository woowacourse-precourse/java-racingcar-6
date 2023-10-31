package racingcar.domain;

public class Car {
    private String name;
    private Integer moveNumber;

    public Car(String name, Integer moveNumber) {
        this.name = name;
        this.moveNumber = moveNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveNumber() {
        return moveNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoveNumber(Integer moveNumber) {
        this.moveNumber = moveNumber;
    }
}
