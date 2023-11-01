package racingcar.io;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.Constant.CAR_NAME_SEPARATOR;
import static racingcar.constant.Message.READ_CAR_NAMES_MESSAGE;
import static racingcar.constant.Message.TRY_COUNT_MESSAGE;


public class InputView {

    private static OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }


    public static List<String> readCarNames() {
        outputView.print(READ_CAR_NAMES_MESSAGE);
        return Arrays.stream(readLine().split(CAR_NAME_SEPARATOR))
                .toList();
    }

    public String readMoveTurnCount() {
        outputView.print(TRY_COUNT_MESSAGE);
        return readLine();
    }
    private static String readLine() {
        return Console.readLine();
    }
}
