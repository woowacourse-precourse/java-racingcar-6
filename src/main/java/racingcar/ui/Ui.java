package racingcar.ui;

import racingcar.domain.Score;

import java.util.List;

import static java.math.BigInteger.ZERO;

public class Ui {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_STATUS_FORMAT = "%s : %s%n";
    private static final String BLANK = "";
    private static final String SCORE_UI = "-";

    public void start() {
        System.out.println(START_MESSAGE);
    }

    public void askPlayCount() {
        System.out.println(ASK_PLAY_COUNT_MESSAGE);
    }

    public void printGameStatus(List<Score> scores) {
        for (Score score : scores) {
            System.out.printf((GAME_STATUS_FORMAT), score.getName(), getScoreUi(score));
        }
        System.out.println();
    }

    private String getScoreUi(Score score) {
        if (score.getScore().equals(ZERO))
            return BLANK;
        StringBuffer scoreUi = new StringBuffer();
        for (long i = 0; i < score.getScore(); i++) {
            scoreUi.append(SCORE_UI);
        }
        return scoreUi.toString();
    }
}
