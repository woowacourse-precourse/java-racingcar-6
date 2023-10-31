package racingcar.racingmanager;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.HandleInput;

import java.util.List;

public class SettingGame {

    private final HandleInput handleInput;

    public SettingGame() {
        this.handleInput = new HandleInput();
    }

    public Race settingRaceAndReturn(){
        List<String> carNames = handleInput.inputCarNames();
        int tryNum = handleInput.inputTryNumber();
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Race(cars, tryNum);
    }

}
