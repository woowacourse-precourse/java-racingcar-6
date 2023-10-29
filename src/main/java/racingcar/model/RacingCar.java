package racingcar.model;

public class RacingCar {
    public String name;
    private int carMoveCount;

    RacingCar(String name) {
        this.name = name;
    }

    public void incrementCarMoveCount() {
        this.carMoveCount++;
    }
}
