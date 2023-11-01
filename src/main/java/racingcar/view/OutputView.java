package racingcar.view;

import java.util.List;
import racingcar.domain.game.RaceGameResult;

public class OutputView {

    private static final String START_RACE_GAME = "실행 결과";
    private static final String CAR_POSITION_DELIMITER = " : ";
    private static final String CAR_POSITION_MARK = "-";
    private static final String FINAL_HEAD_OF_RACE_DELIMITER = ", ";
    private static final String FINAL_HEAD_OF_RACE_PREFIX_MESSAGE = "최종 우승자 : ";

    public void printStartRaceGame() {
        System.out.println(START_RACE_GAME);
    }

    public void printRaceGameResults(final List<RaceGameResult> raceResults) {
        raceResults.forEach(this::printEachRaceGameResult);
        System.out.println();
    }

    private void printEachRaceGameResult(final RaceGameResult raceResult) {
        System.out.println(raceResult.carName() + CAR_POSITION_DELIMITER + mark(raceResult.position()));
    }

    private String mark(final int position) {
        return CAR_POSITION_MARK.repeat(position);
    }

    public void printFinalHeadOfRace(final List<String> headOfRaceCarNames) {
        System.out.println(FINAL_HEAD_OF_RACE_PREFIX_MESSAGE +
                String.join(FINAL_HEAD_OF_RACE_DELIMITER, headOfRaceCarNames));
    }
}
