package racingcar.view;

import racingcar.util.Sentence;

public class OutputView {

    public void beforeInputCarNames() {
        System.out.println(Sentence.INPUT_CAR_NAMES.getMessage());
    }

    public void beforeInputTryNumber() {
        System.out.println(Sentence.INPUT_TRY_NUMBERS.getMessage());
    }
}
