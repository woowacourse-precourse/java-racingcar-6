package racingcar;

import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.randomvalue.RandomValueGenerator;
import racingcar.randomvalue.SingleDigitRandomValueGenerator;

public class Application {

    public static void main(String[] args) {
        CarNameParser carNameParser = new CarNameParser();
        new CarMovementDecider(new SingleDigitRandomValueGenerator());

        RacingCarGame racingCarGame = new RacingCarGame(carNameParser, carNameParser);

        UserIo userIo = new UserIo();
        racingCarGame.run(userIo);
    }
}
