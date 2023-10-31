package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class OutputView {

    private final MessageResolver messageResolver = new MessageResolver();


    public void showGameResult(GameResultDto gameResult) {
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

    public void showExecutedMessage() {
        System.out.println("\n실행 결과");
    }

}
