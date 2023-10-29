package racingcar.domain;

public class RacingCar {

    private int id;
    private String name;
    private int distance;

    public void car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void moving(int forward) {
        distance += forward;
    }

}
