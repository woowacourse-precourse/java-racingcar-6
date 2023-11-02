package racingcar.io;

import static racingcar.constant.CarRacingMessage.INPUT_CAR_NAMES_MESSAGE;
import static racingcar.constant.CarRacingMessage.INPUT_TRY_COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;


public class CarRacingInputView {
    private final CarRacingOutputView outputView;

    public CarRacingInputView(CarRacingOutputView outputView) {
        this.outputView = outputView;
    }


    public String readCarNames() {
        outputView.printMessage(INPUT_CAR_NAMES_MESSAGE);
        return readLine();
    }

    public String readTryToMoveTurnCount() {
        outputView.printMessage(INPUT_TRY_COUNT_MESSAGE);
        return readLine();
    }

    // `디미터의 법칙`에 따라 분리
    // 개발자가 Console을 알아야할 필요없이 readLine만 알아도 됨.
    private String readLine() {
        return Console.readLine();
    }
}
