package racingcar.view;


import static racingcar.enums.OutputMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.enums.OutputMessage.TRY_COUNT_INPUT_MESSAGE;

public class OutputView {

    public static void printCarNameInputMessage() {
        System.out.print(CAR_NAME_INPUT_MESSAGE.getOutputMessage());
    }

    public static void printTryCountInputMessage() {
        System.out.print(TRY_COUNT_INPUT_MESSAGE.getOutputMessage());
    }

}
