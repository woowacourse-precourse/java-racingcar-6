package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRAIL_NUMBER = "시도할 회수는 몇회인가요?";

    public String getCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        String input = Console.readLine();
        Validator.validateIsBlank(input);
        return input;
    }

    public String getTrialNumber() {
        System.out.println(ASK_TRAIL_NUMBER);
        String input = Console.readLine();
        Validator.validateIsBlank(input);
        return input;
    }
}