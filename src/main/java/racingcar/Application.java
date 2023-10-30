package racingcar;

import java.util.Arrays;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        OutputView outputView = new OutputView();
        outputView.printWinners(Arrays.asList("pobi", "jun"));
    }
}
