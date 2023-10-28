package racingcar.domain.racingGame;

import camp.nextstep.edu.missionutils.Console;

public class TryCountManager {
    private int tryCount;

    public void makeTryCount() {
        setTryCount(askTryCount());
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    private int askTryCount() {
        printAskTryCount();
        int input = inputTryCount();
        addBlank();
        return input;
    }

    private void addBlank() {
        System.out.println();
    }

    private int inputTryCount() {
        return Integer.parseInt(Console.readLine());
    }

    private void printAskTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void invokeForTryCount(Runnable runnable) {
        while (tryCount-- > 0) {
            runnable.run();
        }
    }
}
