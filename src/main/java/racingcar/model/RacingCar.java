package racingcar.model;

public class RacingCar {
    private String carName;
    private int currentPosition;
    public void moveFront(int distance){
        this.currentPosition += distance;
    }


}
