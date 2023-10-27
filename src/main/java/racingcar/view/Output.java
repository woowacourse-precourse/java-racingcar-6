package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String MOVEMENT = "-";
    private static final String WINNER_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_DELIMITER = ", ";

    public void showCarNamesInputMessage() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
    }

    public void showCountInputMessage() {
        System.out.println(COUNT_INPUT_MESSAGE);
    }

    public void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showResult(List<Car> cars) {
        for (Car car : cars) {
            String formattedResult = String.format(RESULT_FORMAT, car.getName(), MOVEMENT.repeat(car.getMoveCount()));
            System.out.println(formattedResult);
        }
        System.out.println();
    }

    public void showWinners(List<Car> winners) {
        String winnerNames
                = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));

        String formattedWinner = String.format(WINNER_FORMAT, winnerNames);
        System.out.println(formattedWinner);
    }
}
