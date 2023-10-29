package racingcar.dto;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        distance = 0;
    }

    public void moveForword() {
        distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getName(){
        return name;
    }
}
