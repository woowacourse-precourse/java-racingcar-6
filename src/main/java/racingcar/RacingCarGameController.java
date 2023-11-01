package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.List;

public class RacingCarGameController {

    private static final String DELIMITER = ",";

    private RacingCarGame racingCarGame;
    private int numOfMoves;

    public void gameInit() {
        String[] carNames = processCarNames();
        this.racingCarGame = new RacingCarGame(carNames);
        this.numOfMoves = processNumOfMoves();
    }

    private static String[] processCarNames() {
        String[] carNames = receiveCarNames().split(DELIMITER);
        trimCarName(carNames);
        replaceNoName(carNames);
        checkCarNames(carNames);
        return carNames;
    }

    public void runGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < numOfMoves; i++) {
            List<Result> results = racingCarGame.run();
            printResults(results);
        }
        printWinners(racingCarGame.reportWinners());
    }

    private static String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)");
        return Console.readLine();
    }

    private static void checkCarNames(String[] carNames) {
        checkEmpty(carNames);
        checkCarNamesLength(carNames);
    }

    private static void checkEmpty(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    protected static void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static void trimCarName(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private static void replaceNoName(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].isEmpty()) {
                carNames[i] = "null";
            }
        }

    }

    private static int processNumOfMoves() {
        String userInput = receiveNumOfMoves();
        return parseNumOfMoves(userInput);
    }

    private static String receiveNumOfMoves() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

    protected static int parseNumOfMoves(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            String errorMessage = processNumberFormatException(userInput);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static String processNumberFormatException(String userInput) {
        try {
            new BigInteger(userInput);
        } catch (NumberFormatException ne) {
            return "숫자를 입력해주세요.";
        }
        return Integer.MAX_VALUE + "보다 작은 수를 입력해주세요.";
    }

    private static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
