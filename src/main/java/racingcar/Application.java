package racingcar;

import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.randomvalue.SingleDigitRandomValueGenerator;
import racingcar.result.RacingCarResultFormatter;

public class Application {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(
                new RacingGameInteractionHandler(new UserIo(), new CarNameParser(), new RacingCarResultFormatter()),
                new CarMovementDecider(new SingleDigitRandomValueGenerator())
        );

        racingCarGame.run();
    }
}
