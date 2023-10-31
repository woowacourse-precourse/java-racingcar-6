package racingcar;

import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.randomvalue.SingleDigitRandomValueGenerator;
import racingcar.result.RacingCarResultFormatter;

public class Application {

    public static void main(String[] args) {
        CarNameParser carNameParser = new CarNameParser();
        CarMovementDecider carMovementDecider = new CarMovementDecider(new SingleDigitRandomValueGenerator());
        RacingCarResultFormatter racingCarResultFormatter = new RacingCarResultFormatter();

        RacingCarGame racingCarGame = new RacingCarGame(carNameParser, carMovementDecider, racingCarResultFormatter);

        UserIo userIo = new UserIo();
        racingCarGame.run(userIo);
    }
}
