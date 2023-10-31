package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA = ",";

    public List<String> askCarNames() {
        println(ASK_CAR_NAMES);
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(COMMA);
        return List.of(carNames);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
