package racingcar;

import static racingcar.Enum.ANNOUNCE_INPUT_CAR_NAME_BY_COMMA;
import static racingcar.Enum.RESULT;
import static racingcar.Enum.ANNOUNCE_INPUT_TRIAL_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        CheckValidation checkValidation = new CheckValidation();
        ArrayList<String> carNameList;
        String input;

        System.out.println(ANNOUNCE_INPUT_CAR_NAME_BY_COMMA.getMessage());
        input = Console.readLine();
        carNameList = checkValidation.checkCarName(input);

        System.out.println(ANNOUNCE_INPUT_TRIAL_COUNT.getMessage());
        input = Console.readLine();
        int countTrial = checkValidation.checkIfIntAndReturnIntForm(input);

        System.out.println(RESULT.getMessage());
        CarRacing carRacing = new CarRacing(carNameList, countTrial);
        carRacing.race();
        carRacing.printWinner();
    }
}