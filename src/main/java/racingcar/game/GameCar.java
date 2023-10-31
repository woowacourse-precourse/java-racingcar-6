package racingcar.game;

import racingcar.Object.Car;

public class GameCar {
    private Car car = new Car();
    private String name;
    private int position = 0;

    public GameCar(String name) {
        this.name = name;
    }

    public void move() {
        this.position = this.car.move(this.position);
    }

    public int getPosition() {
        return position;
    }
}
