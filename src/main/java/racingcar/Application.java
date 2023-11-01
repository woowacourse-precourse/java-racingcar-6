package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.ui.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> delimitedCarNames = Converter.delimitCarNames(InputView.inputCarNames());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < delimitedCarNames.size(); i++) {
            cars.add(new Car(delimitedCarNames.get(i)));
        }
        int attempts = Converter.convertAttempts(InputView.inputAttempts());
        NumberGenerator numberGenerator = new NumberGenerator();

        GamePlayer gamePlayer = new GamePlayer(cars, attempts, numberGenerator);
        gamePlayer.play();
    }
}
