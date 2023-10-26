package racingcar.view;

import racingcar.controller.dto.GameResultResponse;
import racingcar.controller.dto.GameWinnerResponse;

public class ConsoleOutputView implements OutputView {

    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_ATTEMPTS_NUMBER_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    @Override
    public void printCarNameRequestMessage() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    @Override
    public void printGameAttemptsNumberRequestMessage() {
        System.out.println(GAME_ATTEMPTS_NUMBER_REQUEST_MESSAGE);
    }

    @Override
    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    @Override
    public void printGameResult(final GameResultResponse gameResultResponse) {
    }

    @Override
    public void printWinner(final GameWinnerResponse gameWinnerResponse) {
    }
}
