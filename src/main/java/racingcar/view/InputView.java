package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Parser;
import racingcar.utils.Validator;

public class InputView {

    public List<String> getCarNames() {
        String input = Console.readLine();
        Validator.validateIsBlank(input);

        List<String> namesInput = Parser.splitByCommaConvertToList(input);
        namesInput.forEach(Validator::validateIsBlank);

        return namesInput;
    }

    public int getTrialNumber() {
        String input = Console.readLine();
        Validator.validateIsBlank(input);
        Validator.validateIsInteger(input.trim());
        Validator.isPositiveInteger(input.trim());

        return Integer.parseInt(input.trim());
    }
}