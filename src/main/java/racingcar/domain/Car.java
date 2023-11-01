package racingcar.domain;

public class Car {
    private String name;
    private int moveCheck;
    private String race;

    public Car() {
    }
    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCheck() {
        return moveCheck;
    }

    public String getRace() {
        return race;
    }

    public void addMove(){
        this.moveCheck++;
        this.race += "-";
    }





}
