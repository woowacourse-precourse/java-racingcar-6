package racingcar.domain;

public class Game {

    private final Cars cars;
    public Game(Cars cars) {
        this.cars = cars;
    }

    private void moveCars() {
        for (int index = 0; index < cars.size(); index++) {
            if (Utils.getRandomNumber() >= 4) {
                cars.moveCarPosition(index);
            }
        }
    }
}
