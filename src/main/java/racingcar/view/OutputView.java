package racingcar.view;


import racingcar.domain.RacingGame;
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
}
