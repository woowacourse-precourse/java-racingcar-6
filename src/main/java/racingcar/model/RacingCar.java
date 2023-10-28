package racingcar.model;

public class RacingCar {
    private String name;
    private int distance;
    public RacingCar(String name){
        this.name = name;
    }
    public void moveForward(int distance){
        this.distance += distance;
    }
}
