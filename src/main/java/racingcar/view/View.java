package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.validation.ValidatorAttempts;

public class View {
    ValidatorAttempts validator = new ValidatorAttempts();

    public String[] askForCarNames() {
        return getCarNames();
    }

    public int askForAttempts() {
        return getAttempts();
    }

    public void displayResult() {
        System.out.println("\n실행결과");
    }

    public void displayWinners(String winners) {
        System.out.printf("최종 우승자 : %s\n", winners);
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    private int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validator.isValid(input);
        return Integer.parseInt(input);
    }

}
