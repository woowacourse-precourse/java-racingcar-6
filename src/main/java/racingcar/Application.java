package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static String getUserInputForCarNames() {
        return Console.readLine();
    }
    public static void main(String[] args) {
        printCarNamePrompt();
        String inputCarNames = getUserInputForCarNames();
        String[] splitCarNames = inputCarNames.split(",");
        System.out.println(splitCarNames[0]);

    }
}
