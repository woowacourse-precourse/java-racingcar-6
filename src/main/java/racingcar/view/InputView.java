package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidation validation = new InputValidation();

    public String readName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validation.readNameValidation(input);
        return input;
    }

    public int readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validation.readCountValidation(input);
        return Integer.parseInt(input);
    }
}
