package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
    public void start() {
        System.out.println(Constants.INPUT_CAR_NAMES);
        String carNames = Console.readLine();
        System.out.println(Constants.INPUT_NUMBER);
        int number = Integer.parseInt(Console.readLine());

        run();
    }

    private void run() {
        // TODO: Car 생성

        System.out.println("\n" + Constants.OUTPUT_GAME_RESULT);

        // TODO: Car 경주 실행

        exist();
    }

    private void exist() {
        System.out.print(Constants.OUTPUT_GAME_WINNER);
    }
}
