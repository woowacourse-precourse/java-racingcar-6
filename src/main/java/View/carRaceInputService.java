package View;

import Utility.StringModifier;
import Validator.GameRoundValidator;
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
        String input = Console.readLine();
        return StringModifier.getInstance().separateCarNamesBySeparator(input, carRaceInputService.SEPARATOR);
    }

    public int askUserGameRound() {
        String input = Console.readLine();
        return GameRoundValidator.getInstance().validateGameRoundAndReturn(input);


    }


}
