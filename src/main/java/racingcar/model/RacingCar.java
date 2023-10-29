package racingcar.model;

public class RacingCar {
    private String name;
    private int distance;
    public RacingCar(String name){
        this.name = name;
        this.distance = -1;
    }
    public void moveForward(int distance){
        this.distance += distance;
    }
    public int getDistance(){   //  테스트용 코도
        return this.distance;
    }
}
