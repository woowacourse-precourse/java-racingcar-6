package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String names = inputView.inputCarName();
        List<String> nameList = inputView.splitNames(names);
        Racing racing = new Racing(nameList);

        int round = inputView.inputTryNumber();

        String racingResult = racing.startRacing(round);

        outputView.getRacingResult(racingResult);

        List<String> winner = racing.determineWinner();
        outputView.getWinnerMessage(winner);
    }
}
