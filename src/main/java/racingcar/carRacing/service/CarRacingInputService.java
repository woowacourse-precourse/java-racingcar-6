package racingcar.carRacing.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validation.Validation.areLessThenSixLetters;
import static racingcar.validation.Validation.containDuplicateCarName;

import java.util.List;

public class CarRacingInputService {
    public static List<String> inputCarNameList() throws IllegalArgumentException {
        String carNameString = readLine();
        List<String> carNames = List.of(carNameString.split(","));

        areLessThenSixLetters(carNames);
        containDuplicateCarName(carNames);
        return carNames;
    }

}
