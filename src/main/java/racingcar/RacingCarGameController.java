package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {

    private static final String DELIMITER = ",";

    private RacingCarGame racingCarGame;
    private int numOfMoves;

    public void gameInit() {
        String userInput = receiveCarNames();
        String[] carNames = userInput.split(DELIMITER);
        checkCarNamesLength(carNames);
        this.numOfMoves = receiveNumOfMoves();

        this.racingCarGame = new RacingCarGame(carNames);
    }

    public void runGame() {
        System.out.println("실행 결과");
        List<Result> results;
        for (int i = 0; i < numOfMoves; i++) {
            results = racingCarGame.run();
            printResults(results);
        }
        printWinners(racingCarGame.reportWinners());
    }

    private static String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)");
        return Console.readLine();
    }

    protected static void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static int receiveNumOfMoves() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String userInput = Console.readLine();
        return parseNumOfMoves(userInput);
    }

    protected static int parseNumOfMoves(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
