package racingcar.view;

import racingcar.model.race.CarRaceRecord;
import racingcar.model.race.CarRaceRecords;
import racingcar.model.race.RaceResult;

public class ResultView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNERS = "최종 우승자 : ";

    private static final String TRACE = "-";
    private static final String LINE_FEED = "\n";
    private static final String RESULT_FORMAT = "%s : %s%n";

    public void printResult(RaceResult result) {
        System.out.println(GAME_RESULT);
        for (CarRaceRecords records : result.get()) {
            printRecords(records);
        }
    }

    private void printRecords(CarRaceRecords records) {
        for (CarRaceRecord record : records.getCarRecords()) {
            printRecord(record);
        }
        System.out.println();
    }

    private void printRecord(CarRaceRecord record) {
        System.out.printf(RESULT_FORMAT, record.carName(), TRACE.repeat(record.distance()));
    }
}
