package racingcar.view;

import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class OutputView {

    private final MessageResolver messageResolver = new MessageResolver();

    public void showRoundResult(RoundResultDto roundResultDto) {
        System.out.println(messageResolver.resolveRoundResultMessage(roundResultDto));
    }

    public void showGameResult(GameResultDto gameResult) {
        System.out.println(messageResolver.resolveWinnerMessage(gameResult));
    }

    public void showExecutedMessage() {
        System.out.println("\n실행 결과");
    }

}
