package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class InputHandler {
    private static InputValidator inputValidator = new InputValidator();
    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getCarList(inputValidator.validateCarName(Console.readLine()));
    }

    private List<String> getCarList(String input) {
        return List.of(input.split(","));
    }

    public int inputMatchCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return inputValidator.validateMatchCount(Console.readLine());
    }
}
