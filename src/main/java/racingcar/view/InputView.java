package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.Vars.REQUEST_INPUT_CAR_NAME;
import static racingcar.Vars.REQUEST_INPUT_NUMBER_OF_ROUNDS;
import static racingcar.Vars.NAME_CLASSIFICATION_CRITERIA;


public class InputView {
    public static String[] inputCarNames() {
        System.out.println(REQUEST_INPUT_CAR_NAME);
        return Console.readLine().split(NAME_CLASSIFICATION_CRITERIA);
    }

    public static String inputRaceRounds() {
        System.out.println(REQUEST_INPUT_NUMBER_OF_ROUNDS);
        return Console.readLine();
    }
}
