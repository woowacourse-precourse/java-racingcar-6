package racingcar.model;

public class Car {
    String name;
    Integer location;
    Boolean isWinner;

    public Car(String name) {
        this.name = name;
        location = 0;
        isWinner = false;
    }

    public void move(Integer distance){
        location += distance;
    }
    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setWinner() {
        isWinner = true;
    }

    public Boolean isWinner() {
        return isWinner;
    }
}
