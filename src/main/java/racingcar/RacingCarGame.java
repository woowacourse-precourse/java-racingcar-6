package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    static void printAskingForCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static String getUserInput() {
        return Console.readLine();
    }

    static List<String> splitGamePlayers(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    static void printAskingForTrialNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    static int convertStringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    static void printExecutionResult() {
        System.out.println("실행 결과");
    }
}
