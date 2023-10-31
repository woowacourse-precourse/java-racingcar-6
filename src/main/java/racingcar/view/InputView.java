package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_START = "경주할 자동차 이름을 입력하세요.(이름은  쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT = "시도할 회수는 몇회인가요?";
    private static final String SPLIT_CONDITION = ",";

    public String[] getCarNames() {
        System.out.println(INPUT_START);
        String carNames = Console.readLine();
        return splitCarNames(carNames);
    }

    public int getAttemptNumber() {
        System.out.println(INPUT_ATTEMPT);
        String attempt = Console.readLine();
        return Integer.parseInt(attempt);
    }

    public String[] splitCarNames(String input) {
        return input.split(SPLIT_CONDITION);
    }
}
