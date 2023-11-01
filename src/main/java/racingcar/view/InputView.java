package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.validate.Validator;

public class InputView {

    public int getNumberOfAttempts() {
        return 0;
    }

    public List<String> inputName() {
        List<String> carName = splitString(Console.readLine());
        Validator.inputNameSize(carName);
        return carName;
    }

    public int inputRound() {
        return Integer.parseInt(Console.readLine());
    }

    private List<String> splitString(String input) {
        List<String> str = new ArrayList<>();
        str = List.of(input.split(","));
        return str;
    }
}
