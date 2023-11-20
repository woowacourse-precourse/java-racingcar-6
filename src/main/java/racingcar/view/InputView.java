package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Parser;
import racingcar.utils.Validator;

public class InputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRIAL_NUMBER = "시도할 회수는 몇회인가요?";

    public List<String> getCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        String input = Console.readLine();
        Validator.validateIsBlank(input);

        List<String> namesInput = Parser.splitByCommaConvertToList(input);
        namesInput.forEach(Validator::validateIsBlank);

        return namesInput;
    }

    public int getTrialNumber() {
        System.out.println(REQUEST_TRIAL_NUMBER);
        String input = Console.readLine();
        Validator.validateIsBlank(input);
        Validator.validateIsInteger(input.trim());
        Validator.isPositiveInteger(input.trim());

        return Integer.parseInt(input.trim());
    }
}