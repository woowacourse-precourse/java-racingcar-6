package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    public static List<String> carName() {
        String names = Console.readLine();
        List<String> carNames = DataTypeChanger.stringToList(names);
        Validator.validateCarName(carNames);
        return carNames;
    }

    public static int trialCount() {
        String trialCount = Console.readLine();
        Validator.validateTrialCount(trialCount);
        return Integer.parseInt(trialCount);
    }

}
