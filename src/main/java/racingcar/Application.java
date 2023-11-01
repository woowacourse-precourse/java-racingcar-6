package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.ui.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> delimitedCarNames = Converter.delimitCarNames(InputView.inputCarNames());
        List<Car> cars = new ArrayList<>();
        for (String delimitedCarName : delimitedCarNames) {
            cars.add(new Car(delimitedCarName));
        }
        int round = Converter.convertRound(InputView.inputRound());

        Game game = new Game(cars, round);
        game.playAllRound();
    }
}
