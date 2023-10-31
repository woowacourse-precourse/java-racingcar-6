package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String names = inputView.inputCarName();
        List<String> nameList = inputView.splitNames(names);

        int round = inputView.inputTryNumber();

        Racing racing = new Racing(nameList);

        Map<String, List<Integer>> result = racing.startRacing(round);

        outputView.roundResult(result, round);

        List<String> winner = racing.determineWinner();
        outputView.getWinnerMessage(winner);
    }
}
