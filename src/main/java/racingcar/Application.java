package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.askCarNames();
        int roundNumber = inputView.askRoundNumber();
        for (String carName : carNames) {
            Car car = new Car(carName);
        }
    }
}
