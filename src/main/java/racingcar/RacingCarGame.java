package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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

    static void validateCarNameLength(List<String> carNamesList) {
        for (int i = 0; i < carNamesList.size(); i++) {
            if (carNamesList.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    static void printAskingForTrialNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    static int convertStringToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static void printExecutionResult() {
        System.out.println("실행 결과");
    }

    static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    static void executePerCar(int i, List<String>[] progressOfCarRacing) {
        int number = getRandomNumber();
        if (number >= 4) {
            progressOfCarRacing[i].add("-");
        }
    }
}
