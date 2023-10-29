package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.utils.Parser.*;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        //todo 입력값 겁증
        return parseStrings(input);
    }

    public Integer inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        String input = Console.readLine();
        //todo 입력값 검증
        return parseInteger(input);
    }
}
