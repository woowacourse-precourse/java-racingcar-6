package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> delimitedCarNames = Converter.delimitCarNames(InputView.inputCarNames());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < delimitedCarNames.size(); i++) {
            cars.add(new Car(delimitedCarNames.get(i)));
        }
        int attempts = Converter.convertAttempts(InputView.inputAttempts());
        RandomNumber randomNumber = new RandomNumber();

        GamePlayer gamePlayer = new GamePlayer(cars, attempts, randomNumber);
        gamePlayer.play();
    }
}
