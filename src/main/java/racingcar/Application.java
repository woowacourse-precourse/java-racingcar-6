package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static String getUserInput() {
        return Console.readLine();
    }
    public static void validateAndThrow(String[] splitCarNames) {
        for (String carName : splitCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하로 작성해야 합니다.");
            }
        }
    }
    public static void printAttemptsPrompt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public static void main(String[] args) {
        printCarNamePrompt();
        String inputCarNames = getUserInput();
        String[] splitCarNames = inputCarNames.split(",");

        validateAndThrow(splitCarNames);
        printAttemptsPrompt();
        String inputAttempts = getUserInput();

    }
}
