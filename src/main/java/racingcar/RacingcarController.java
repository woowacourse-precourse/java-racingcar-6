package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingcarController {
    Input input = new Input();
    Cars cars = new Cars();

    public void playRacingcarGame() {
        inputCarsName();
    }

    private void inputCarsName() {
        for (String name : input.inputCarName().split(",")) {
            Car car = new Car(name.trim(), 0);
            cars.addCarList(car);
        }
    }
}
