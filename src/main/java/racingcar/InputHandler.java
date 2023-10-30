package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private boolean validateInput(String input) {}
    private List<String> divideByComma(String input) {}
    private boolean lengthChecker(String word) {}
}
