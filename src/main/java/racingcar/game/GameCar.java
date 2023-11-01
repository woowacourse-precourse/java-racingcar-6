package racingcar.game;

import racingcar.Object.Car;

public class GameCar {
    private final Car car = new Car();
    private final String name;
    private int position = 0;

    public GameCar(String name) {
        this.name = name;
    }

    public void move() {
        this.position = this.car.move(this.position);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
