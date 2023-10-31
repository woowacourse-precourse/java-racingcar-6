package racingcar.domain.racinggame.trycountfactory;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.racinggame.validator.TryCountValidator;

public class InputTryCountFactory implements TryCountFactory {

    private final TryCountValidator tryCountValidator;

    public InputTryCountFactory(TryCountValidator tryCountValidator) {
        this.tryCountValidator = tryCountValidator;
    }

    @Override
    public int createTryCount() {
        return askTryCount();
    }

    private int askTryCount() {
        printAskTryCount();
        int input = inputTryCount();
        addBlank();
        return input;
    }

    private void printAskTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void addBlank() {
        System.out.println();
    }

    private int inputTryCount() {
        String input = Console.readLine();
        tryCountValidator.validateTryCount(input);
        return Integer.parseInt(input);
    }
}
