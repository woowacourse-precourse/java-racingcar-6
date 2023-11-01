package racingcar.view;


import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.util.StringUtil;

public class OutputView {
    private final StringUtil stringUtil;

    public OutputView(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public void printCurrentResult(RacingGame game) {
        String result = stringUtil.makeResultMessage(game);
        System.out.println(result);
    }

    public void printWinner(RacingGameResult gameResult) {
        String result = stringUtil.makeFinalResult(gameResult);
        System.out.println(result);
    }
}
