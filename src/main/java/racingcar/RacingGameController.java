package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameController {
    private RacingGame racingGame;

    public void startGame() {
        initializeGame();
        racingGame.playGame();
        racingGame.announceWinners();
    }

    private void initializeGame() {
        String carNames = getCarNames();
        int attempts = getAttempts();
        racingGame = new RacingGame(carNames, attempts);
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}