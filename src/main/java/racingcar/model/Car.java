package racingcar.model;

public class Car {
    private final String name;
    private int movedDistance;
    public Car(String name) {
        this.name= name;
        this.movedDistance = 0;
    }
    public void move(){
        movedDistance++;
    }
    public String getName(){
        return this.name;
    }
    public int getMoveDistance(){
        return movedDistance;
    }
}