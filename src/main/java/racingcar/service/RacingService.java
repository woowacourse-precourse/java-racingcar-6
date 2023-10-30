package racingcar.service;

import static racingcar.validation.Validation.inputCarNameValidate;
import static racingcar.view.InputView.inputCarNameMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingService {
    /*
    * 1. receive car name
    * 2. receive racing time
    * 3. make car
    * 4. move car
    * 5. check winner
    * */

    public List<String> inputCarName() {
        inputCarNameMessage();
        String carNames = Console.readLine();
        List<String> carName = divideCarName(carNames);
        return carName;
    }

    private static List<String> divideCarName(String carNames) {
        List<String> carName = Arrays.stream(carNames.split(","))
                .toList();
        inputCarNameValidate(carName);
        return carName;
    }

}
