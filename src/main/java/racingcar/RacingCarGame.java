package racingcar;

import java.util.List;
import racingcar.car.name.CarName;
import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;

public class RacingCarGame {

    private final CarNameParser carNameParser;

    public RacingCarGame(CarNameParser carNameParser) {
        this.carNameParser = carNameParser;
    }

    public void run(UserIo userIo) {
        List<CarName> carNameList = getCarNameList(userIo);

        RacingAttempt racingAttempt = getRacingAttempt(userIo);
    }

    private List<CarName> getCarNameList(UserIo userIo) {
        userIo.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carNameLine = userIo.readLine();
        return carNameParser.parse(carNameLine);
    }

    private RacingAttempt getRacingAttempt(UserIo userIo) {
        userIo.print("시도할 회수는 몇회인가요?\n");
        return new RacingAttempt(userIo.readLine());
    }
}
