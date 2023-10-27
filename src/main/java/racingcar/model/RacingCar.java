package racingcar.model;

public class RacingCar {
    private String carName;
    private int currentPosition;
    public RacingCar(String name){
        this.carName = name;
        this.currentPosition = 0;
    }
    public void moveFront(int distance){
        this.currentPosition += distance;
    }


}
