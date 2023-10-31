package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public void startGame() {
        InputView inputView = new InputView();
        inputView.pirntStartMsg();

        User user = new User();

        inputView.printCarNameInputMsg();
        user.inputCarName();
        List<String> carNames = user.getCarNames();
        List<Car> Cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        inputView.printTryCountInputMsg();
        user.inputTryCount();

        int tryCount = user.getTryCount();
    }
}
