package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

class Printer {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

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
            car -> System.out.printf("%s : %s%n", car.name(), "-".repeat(car.moveCount())));
    }

    void printWinnerResult(List<Car> winners) {
        String result = winners.stream().map(Car::name).collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s", result);
    }
}
