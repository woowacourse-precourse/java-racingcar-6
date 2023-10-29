package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.domain.Output;
import racingcar.domain.TryCount;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.printCarInputMessage();
        String[] carArray = Input.getCarsByUser();
        Cars cars = new Cars(carArray);
        Output.printTryCountInputMessage();
        TryCount tryCount = new TryCount(Input.getTryCountByUser());
        Output.printResultMessage();

        Game game = new Game(cars, tryCount);
        game.run();
    }
}
