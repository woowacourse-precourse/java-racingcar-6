package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {

    private static final String DELIMITER = ",";

    private RacingCarGame racingCarGame;

    public void gameInit() {
        String userInput = receiveCarNames();
        String[] carNames = userInput.split(DELIMITER);
        checkCarNamesLength(carNames);
        long numOfMoves = receiveNumOfMoves();

        this.racingCarGame = new RacingCarGame(carNames, numOfMoves);
    }

    public void gameStart() {
        List<Result> results = racingCarGame.run();
    }

    private static String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)");
        return Console.readLine();
    }

    static void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static long receiveNumOfMoves() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String userInput = Console.readLine();
        return parseNumOfMoves(userInput);
    }

    static long parseNumOfMoves(String userInput) {
        try {
            return Long.parseLong(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
