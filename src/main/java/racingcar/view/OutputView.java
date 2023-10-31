package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class OutputView {

    private static final String EXECUTION_MESSAGE_PREFIX = "\n실행 결과";

    private final MessageResolver messageResolver = new MessageResolver();


    public void showGameResult(GameResultDto gameResult) {
        showResultMessagePrefix();
        showRoundHistories(gameResult.getRoundHistories());
        showWinners(gameResult.getWinners());
    }

    private void showWinners(List<CarStatusDto> winner) {
        System.out.println(messageResolver.resolveWinnerMessage(winner));
    }

    private void showRoundHistories(List<RoundResultDto> roundHistories) {
        roundHistories.forEach(this::showRoundResult);
    }

    public void showRoundResult(RoundResultDto roundResultDto) {
        System.out.println(messageResolver.resolveRoundResultMessage(roundResultDto));
    }

    public void showResultMessagePrefix() {
        System.out.println(EXECUTION_MESSAGE_PREFIX);
    }

}
