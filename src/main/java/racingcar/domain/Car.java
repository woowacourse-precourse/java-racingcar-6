package racingcar.domain;

public class Car {
    private String carName;
    private int moveForwardCount;

    public Car(String carName){
        this.carName = carName;
    }

    public void setMoveForwardCount(int moveForwardCount){
        this.moveForwardCount = moveForwardCount;
    }

    public String getCarName(){
        return carName;
    }

    public int getMoveForwardCount(){
        return moveForwardCount;
    }
}
