package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOHandler {

    private final InputValidator validator = new InputValidator();

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carNames = List.of(Console.readLine().split(","));
        validator.validateCarNames(carNames);

        return carNames;
    }

    public int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        String input = Console.readLine();
        validator.validateAttemptCount(input);

        return Integer.parseInt(input);
    }

    public void printWinners(List<String> winners) {
        String names = String.join(", ", winners);
        System.out.println("최종 우승 : " + names);
    }

}
