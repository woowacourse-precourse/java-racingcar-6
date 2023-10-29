package racingcar.domain;

public class Car {
    private String name;
    private boolean moveCheck;
    private String race;

    public Car() {
    }
    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getMoveCheck() {
        return moveCheck;
    }

    public String getRace() {
        return race;
    }



}
