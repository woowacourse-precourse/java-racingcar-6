package racingcar.view;

import racingcar.model.race.CarRaceRecord;
import racingcar.model.race.CarRaceRecords;
import racingcar.model.race.RaceResult;

public class ResultView {

    private static final String GAME_RESULT = "\n실행 결과";
    private static final String WINNERS = "최종 우승자 : ";

    private static final String TRACE = "-";
    private static final String RESULT_FORMAT = "%s : %s%n";

    public void printResult(RaceResult result) {
        System.out.println(GAME_RESULT);
        result.get().forEach(this::printRecords);
    }

    private void printRecords(CarRaceRecords records) {
        records.getCarRecords().forEach(this::printRecord);
        System.out.println();
    }

    private void printRecord(CarRaceRecord record) {
        System.out.printf(RESULT_FORMAT, record.carName(), TRACE.repeat(record.distance()));
    }
}
