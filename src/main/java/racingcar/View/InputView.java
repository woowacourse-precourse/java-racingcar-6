package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Util.Validator;

public class InputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL = "시도할 회수는 몇회인가요?";
    Validator validator = new Validator();

    public String[] printStart(){
        System.out.println(START_MESSAGE);
        return validator.validationCarName(Console.readLine());
    }
}
