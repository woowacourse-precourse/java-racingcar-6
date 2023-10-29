package racingcar.domain.racingGame;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.racingGame.validator.TryCountValidator;

public class TryCountManager {
    public static final int MAX_TRY_COUNT = 100;
    private int tryCount;

    private final TryCountValidator tryCountValidator;

    public TryCountManager(TryCountValidator tryCountValidator) {
        this.tryCountValidator = tryCountValidator;
    }

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
        String input = Console.readLine();
        tryCountValidator.validateTryCount(input);
        return Integer.parseInt(input);
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
