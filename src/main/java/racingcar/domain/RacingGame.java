package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    public void play() {
        printAskTryCount();
        int tryCount = inputTryCount();
    }

    private int inputTryCount() {
        return Integer.parseInt(Console.readLine());
    }

    private void printAskTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
