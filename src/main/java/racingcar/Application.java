package racingcar;

import java.util.List;

import static racingcar.Formatter.formatCarNames;
import static racingcar.Formatter.formatRound;

public class Application {
    public static void main(String[] args) {
        String carWithComma = UserInputManager.getCarWithComma();
        String roundStr = UserInputManager.getRoundStr();

        List<String> formattedCarNames = formatCarNames(carWithComma);
        int round = formatRound(roundStr);

        RacingCarGameManager racingCarGameManager = new RacingCarGameManager(round, formattedCarNames);
        racingCarGameManager.start();
    }
}
