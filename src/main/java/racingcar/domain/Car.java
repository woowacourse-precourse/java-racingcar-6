package racingcar.domain;

public class Car {
    private final String name;
    private int raceDistance;
    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        this.raceDistance++;
    }


}
