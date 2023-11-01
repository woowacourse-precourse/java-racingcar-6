package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String POSITION_OUTPUT_FORM = " : ";
    private static final String POSITION_DELIMITER = "-";

    public OutputView() {
    }

    public void inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void inputAttempts() {
        System.out.println(INPUT_ATTEMPTS);
    }

    public void printResultTitle() {
        System.out.println(RESULT_MESSAGE);
    }
    public void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + POSITION_OUTPUT_FORM + POSITION_DELIMITER.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> carList) {
        System.out.print(WINNER_MESSAGE);
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName());
            if (i != carList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
