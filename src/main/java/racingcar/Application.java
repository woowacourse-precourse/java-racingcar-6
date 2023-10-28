package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.domain.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.printCarInputMessage();
        String[] carArray = Input.getCars();
        Output.printTryCountInputMessage();
        int tryCount = Input.getTryCount();

        System.out.println("실행 결과");
        Cars cars = new Cars(carArray);
        Game game = new Game(cars, tryCount);
        game.racingGame();
    }
}
