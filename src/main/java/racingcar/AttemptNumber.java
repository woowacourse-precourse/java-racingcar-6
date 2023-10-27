package racingcar;

import racingcar.view.Input;

public class AttemptNumber {

    private final int number;

    public AttemptNumber(Input numberInput) {
        this.number = Integer.parseInt(numberInput.readLine());
    }

    public int getAttemptNumber() {
        return number;
    }
}
