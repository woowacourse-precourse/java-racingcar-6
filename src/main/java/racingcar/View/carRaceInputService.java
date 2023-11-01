package racingcar.View;

import racingcar.Utility.StringModifier;
import racingcar.Validator.GameRoundValidator;
import camp.nextstep.edu.missionutils.Console;

public class carRaceInputService {
    private static carRaceInputService inputView = null;
    private static final String SEPARATOR = ",";

    public static carRaceInputService getInstance() {
        if (carRaceInputService.inputView == null) {
            return carRaceInputService.inputView = new carRaceInputService();
        }
        return carRaceInputService.inputView;
    }


    public String[] askUserCarNames() {
        carRaceOutputService.getInstance().askCarNames();
        String input = Console.readLine();
        return StringModifier.getInstance().separateCarNamesBySeparator(input, carRaceInputService.SEPARATOR);
    }

    public int askUserGameRound() {
        carRaceOutputService.getInstance().askGameRound();
        String input = Console.readLine();
        return GameRoundValidator.getInstance().validateGameRoundAndReturn(input);
    }


}
