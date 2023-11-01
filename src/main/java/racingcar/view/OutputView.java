package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String FOWARD_MARK = "-";
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NO_WINNER_MESSAGE = "우승자가 없습니다.";

    public static void printCarNameRequest() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public static void printAttemptCountRequest() {
        System.out.println(ATTEMPT_COUNT_REQUEST_MESSAGE);
    }

    public static void printRaceStatus(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + renderingCurrentPositionMark(car));
        }
        System.out.println();
    }

    private static String renderingCurrentPositionMark(Car car) {
        StringBuilder currentPositionMark = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            currentPositionMark.append(FOWARD_MARK);
        }
        return currentPositionMark.toString();
    }

    public static void printWinnerName(List<String> winners) {
        if (winners.isEmpty()) {
            printNoWinnerMessage();
            return;
        }
        printWinners(winners);
    }

    private static void printNoWinnerMessage() {
        System.out.println(NO_WINNER_MESSAGE);
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(",", winners));
    }

}
