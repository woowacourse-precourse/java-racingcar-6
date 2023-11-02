package racingcar;

import java.util.List;
import racingcar.car.name.CarName;
import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.result.RacingCarResultFormatter;
import racingcar.result.RacingResult;

public class RacingGameInteractionHandler {

    private final UserIo userIo;
    private final CarNameParser carNameParser;
    private final RacingCarResultFormatter racingCarResultFormatter;

    public RacingGameInteractionHandler(UserIo userIo,
            CarNameParser carNameParser,
            RacingCarResultFormatter racingCarResultFormatter) {
        this.userIo = userIo;
        this.carNameParser = carNameParser;
        this.racingCarResultFormatter = racingCarResultFormatter;
    }

    public List<CarName> readCarNameList() {
        userIo.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carNameLine = userIo.readLine();
        return carNameParser.parse(carNameLine);
    }

    public RacingAttempt readRacingAttempt() {
        userIo.print("시도할 회수는 몇회인가요?\n");
        return new RacingAttempt(userIo.readLine());
    }

    public void announceRaceStart() {
        userIo.print("\n실행결과\n");
    }

    public void printRoundResult(List<RacingResult> rountResultList) {
        userIo.print(racingCarResultFormatter.formatRoundResult(rountResultList));
    }

    public void printFinalResult(List<RacingResult> racingResultList) {
        userIo.print(racingCarResultFormatter.formatFinalResult(racingResultList));
    }
}
