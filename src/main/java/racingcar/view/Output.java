package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

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

    public void showWinners(List<String> winners) {
        String formattedWinner = String.format(WINNER_FORMAT, String.join(WINNER_DELIMITER, winners));
        System.out.println(formattedWinner);
    }
}
