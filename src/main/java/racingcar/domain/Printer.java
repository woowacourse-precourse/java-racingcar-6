package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

class Printer {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RACE_RESULT_FORMAT = "%s : %s%n";
    private static final String DASH = "-";
    private static final String WINNER_RESULT_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_RESULT_JOIN_DELIM = ", ";

    void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    void printCountMessage() {
        System.out.println(COUNT_MESSAGE);
    }

    void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    void printBlankLine() {
        System.out.println();
    }

    void printRaceResult(List<Car> cars) {
        cars.forEach(
            car -> System.out.printf(RACE_RESULT_FORMAT, car.name(), DASH.repeat(car.moveCount())));
    }

    void printWinnerResult(List<Car> winners) {
        String result = winners.stream().map(Car::name)
            .collect(Collectors.joining(WINNER_RESULT_JOIN_DELIM));
        System.out.printf(WINNER_RESULT_FORMAT, result);
    }
}
