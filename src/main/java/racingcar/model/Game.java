package racingcar.model;

public class Game {
    private Car cars;
    private int remainingSet;

    public Game(Car cars, String set) {
        this.cars = cars;
        this.remainingSet = Integer.parseInt(set);
    }
}
