package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String carNames = getCarNames();
        int attempts = getAttempts();
        RacingGame racingGame = new RacingGame(carNames, attempts);
        racingGame.run();

    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String attemptsInput = Console.readLine();
        try {
            return Integer.parseInt(attemptsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}