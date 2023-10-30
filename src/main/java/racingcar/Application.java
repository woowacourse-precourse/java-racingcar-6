package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static String getUserInputForCarNames() {
        return Console.readLine();
    }
    public static void validateAndThrow(String[] splitCarNames) {
        for (String carName : splitCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하로 작성해야 합니다.");
            }
        }
    }
    public static void main(String[] args) {
        printCarNamePrompt();
        String inputCarNames = getUserInputForCarNames();
        String[] splitCarNames = inputCarNames.split(",");

        validateAndThrow(splitCarNames);
    }
}
