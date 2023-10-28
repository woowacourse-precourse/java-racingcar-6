package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validate.CountValidator.numberValidate;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String CARLIST_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarList() {
        System.out.println(CARLIST_INPUT_MESSAGE);
        return Console.readLine();
    }

    public Integer inputCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String inputString = readLine();
        return numberValidate(inputString);
    }
}
