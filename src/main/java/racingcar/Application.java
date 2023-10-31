package racingcar;

import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.randomvalue.RandomValueGenerator;
import racingcar.randomvalue.SingleDigitRandomValueGenerator;

public class Application {

    public static void main(String[] args) {
        CarNameParser carNameParser = new CarNameParser();
        CarMovementDecider carMovementDecider = new CarMovementDecider(new SingleDigitRandomValueGenerator());

        RacingCarGame racingCarGame = new RacingCarGame(carNameParser, carMovementDecider);

        UserIo userIo = new UserIo();
        racingCarGame.run(userIo);
    }
}
