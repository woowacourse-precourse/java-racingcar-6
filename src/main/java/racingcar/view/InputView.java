package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] inputCarNames() {
        System.out.println(showInputCarNamesPrompt());
        String inputList = UserInput();
        String[] inputArr = inputList.split(",");
        return inputArr;
    }

    public String inputTryNumber() {
        System.out.println(showInputTryNumberPrompt());
        String inputNumber = UserInput();
        return inputNumber;
    }

    private String UserInput() {
        return Console.readLine();
    }

    private String showInputCarNamesPrompt() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    private String showInputTryNumberPrompt() {
        return "시도할 회수는 몇회인가요?";
    }
}