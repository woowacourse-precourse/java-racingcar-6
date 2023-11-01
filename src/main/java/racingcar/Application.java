package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameConsole;
import racingcar.domain.InputView;

public class Application {
    public static void main(String[] args) {
        Car car = new Car(InputView.carNames());
        GameConsole gameConsole
                = new GameConsole(car, InputView.timesToTry());
        gameConsole.play();
    }
}
