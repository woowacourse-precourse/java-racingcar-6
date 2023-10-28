package racingcar.domain;

public class RacingCar {

    String name;
    int distance;

    RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    void move() {
        this.distance++;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

}
