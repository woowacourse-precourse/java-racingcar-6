package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarGameController {

    private static final String DELIMITER = ",";

    private RacingCarGame racingCarGame;
    private int numOfMoves;

    public void gameInit() {
        String[] carNames = Preprocessor.processCarNames(receiveCarNames().split(DELIMITER));
        this.racingCarGame = new RacingCarGame(carNames);
        this.numOfMoves = Preprocessor.processNumOfMoves(receiveNumOfMoves());
    }

    public void runGame() {
        System.out.println("\n실행 결과");
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

    private static String receiveNumOfMoves() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

    private static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(DELIMITER + " ", winners));
    }
}
