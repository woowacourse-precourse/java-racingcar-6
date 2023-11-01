package racingcar.domain;

public class Car {
    private String name;
    private Integer moveDistance;

    public Car(){
    }
    public Car(String name){
        this.name = name;
        this.moveDistance = 0;
    }

    public String getName() {
        return name;
    }
    public Integer getMoveDistance() {
        return moveDistance;
    }
    public void moveForward() {
        moveDistance ++;
    }

}