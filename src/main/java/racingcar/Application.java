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
        int round = Converter.convertRound(InputView.inputRound());

        Game game = new Game(cars, round);
        game.play();
    }
}
