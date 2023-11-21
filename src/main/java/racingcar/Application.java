package racingcar;

import racingcar.domain.InitController;
import racingcar.domain.PlayController;
import racingcar.domain.car.Cars;

public class Application {
    private static final InitController initController = new InitController();
    private static final PlayController playController = new PlayController();

    public static void main(String[] args) {
        Cars cars = initController.initCars();
        int rounds = initController.getRounds();

        playController.printResultTitle();
        for (int round = 0; round < rounds; round++) {
            playController.move(cars);
            playController.printRoundResult(cars);
        }
        playController.printWinner(cars);
    }
}
