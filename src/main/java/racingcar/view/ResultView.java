package racingcar.view;

import java.util.StringJoiner;

import racingcar.model.car.CarName;
import racingcar.model.race.CarRaceRecord;
import racingcar.model.race.CarRaceRecords;
import racingcar.model.race.RaceResult;
import racingcar.model.winner.Winners;

public class ResultView {

    private static final String GAME_RESULT = "\n실행 결과";
    private static final String WINNERS = "최종 우승자 : ";

    private static final String TRACE = "-";
    private static final String RESULT_FORMAT = "%s : %s%n";

    private static final String DELIMITER_COMMA = ", ";

    public void printResult(RaceResult result) {
        System.out.println(GAME_RESULT);
        result.stream().forEach(this::printRecords);
    }

    private void printRecords(CarRaceRecords records) {
        records.stream().forEach(this::printRecord);
        System.out.println();
    }

    private void printRecord(CarRaceRecord record) {
        System.out.printf(RESULT_FORMAT, record.carName(), TRACE.repeat(record.distance()));
    }

    public void printWinners(Winners winners) {
        StringJoiner winnerNamesWithCommas = new StringJoiner(DELIMITER_COMMA);
        winners.stream()
                .map(CarName::toString)
                .forEach(winnerNamesWithCommas::add);
        System.out.println(WINNERS + winnerNamesWithCommas);
    }
}
