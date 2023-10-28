package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String OUTPUT_GAME_RESULT_MESSAGE = "실행 결과";
    private final StringBuilder outputBuilder;

    public OutputView() {
        this.outputBuilder = new StringBuilder();
    }


    private void initOutputBuilder() {
        outputBuilder.setLength(0);
    }
}
