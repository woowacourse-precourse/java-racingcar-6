package racingcar.model;

public class Car {
    private final String name;
    private int movedDistance;

    public Car(String name) {
        this.name= name;
        this.movedDistance = 0;
    }
    public String getName(){
        return this.name;
    }
    public void move(){
        movedDistance++;
    }
    public int getMoveDistance(){
        return movedDistance;
    }
}
