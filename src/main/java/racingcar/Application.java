package racingcar;

import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;

public class Application {

    public static void main(String[] args) {
        CarNameParser carNameParser = new CarNameParser();
        RacingCarGame racingCarGame = new RacingCarGame(carNameParser);

        UserIo userIo = new UserIo();
        racingCarGame.run(userIo);
    }
}
