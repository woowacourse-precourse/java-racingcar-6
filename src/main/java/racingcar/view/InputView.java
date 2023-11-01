package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return parseCarNames(Console.readLine());
    }

    public String inputRaceCount() {
        System.out.println(INPUT_RACE_COUNTS_MESSAGE);
        return Console.readLine();
    }

    private List<String> parseCarNames(final String carNames) {
        return List.of(carNames.split(","));
    }
}
