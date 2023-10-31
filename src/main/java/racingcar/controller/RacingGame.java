package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.models.GameStatus;
import racingcar.service.Referee;

import java.util.Arrays;

public class RacingGame {

    private static final String NAME_DELIMITER = ",";
    private static final int MIN_TRY_COUNT = 1;
    private final Referee referee = new Referee();

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        addCarsToReferee(carsInput);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        checkTryCount(tryCount);

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            referee.startTurn();
            GameStatus gameStatus = referee.getGameStatus();
            printGameStatus(gameStatus);
        }

        printGameWinners();
    }

    private void checkTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void printGameWinners() {
        System.out.println("최종 우승자 : " + String.join(", ", referee.getWinners()));
    }

    private void printGameStatus(GameStatus gameStatus) {
        System.out.println(gameStatus);
    }

    private void addCarsToReferee(String carsInput) {
        Arrays.stream(carsInput.split(NAME_DELIMITER))
                .forEach(referee::addCar);
    }
}
