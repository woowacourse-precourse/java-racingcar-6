package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.StringParser;
import racingcar.utils.Validator;

public class InputView {
    Validator validator = new Validator();

    public List<String> getCarsName() {
        String input = Console.readLine();
        List<String> carsName = StringParser.splitStringWithComma(input);

        validator.validateInputCarNameStartOrEndComma(input);
        validator.validateInputCar(carsName);
        return carsName;
    }

    public int getMovingTryCount() {
        String input = Console.readLine();
        validator.validateInputMovingTryCount(input);
        return StringParser.parseStringToInt(input);
    }
}