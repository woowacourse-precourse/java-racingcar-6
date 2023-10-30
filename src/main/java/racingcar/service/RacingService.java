package racingcar.service;

import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.Winner;
import racingcar.view.RacingInput;
import racingcar.view.RacingOutput;

public class RacingService {
    private static List<String> carNameList;
    private static int tryNumber;
    private static Race race;

    public static void initRacing() {
        RacingOutput.printStartRacing();
        carNameList = RacingInput.readCarName();

        RacingOutput.printInputTryNumberMessage();
        tryNumber = RacingInput.readTryNumber();

        progressRacing();
    }

    public static void progressRacing() {
        race = new Race(carNameList);
        RacingOutput.printProcessResultMessage();

        for (int i = 0; i < tryNumber; i++) {
            race.raincingCar();
            RacingOutput.printProcessResult(race.getRacingCar());
        }
    }

    public static void finishRacing() {
        Winner winner = new Winner();
        RacingOutput.printWinnerMessage(winner.findWinners(race.getRacingCar()));
    }
}
