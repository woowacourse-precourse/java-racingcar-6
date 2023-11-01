package racingcar.io;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.Constant.CAR_NAME_SEPARATOR;


public class InputView {

    private static OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }


    public static List<String> readCarNames() {
        outputView.print("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분합니다.)");
        return Arrays.stream(readLine().split(CAR_NAME_SEPARATOR))
                .toList();
    }

    public String readMoveTurnCount() {
        outputView.print("시도 횟수를 입력하세요");
        return readLine();
    }
    private static String readLine() {
        return Console.readLine();
    }
}
