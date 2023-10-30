package racingcar.controller;

import racingcar.dto.GameResult;
import racingcar.model.Racing;
import racingcar.model.RacingImpl;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.util.List;

public class RacingController {

    private Racing racing;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        // 자동차의 이름을 입력받는다.
        outputView.printInputCarNamesMessage();
        List<String> carNames = inputView.inputCarNames();

        // 시도할 횟수를 입력받는다.
        outputView.printInputRetryCountMessage();
        int retryCount = inputView.inputRetryCount();

        // 게임진행
        racing = new RacingImpl(carNames, retryCount);
        List<List<GameResult>> totalGameResults = racing.start();

        // 게임결과 출력
        outputView.printTotalGameResults(totalGameResults);

        // 최종 우승자 출력
        outputView.printWinners(racing.getWinners());
    }
}
