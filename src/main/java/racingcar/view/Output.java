package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String GAME_WINNER = "최종 우승자 : ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printGameWinner(List<String> winners) {
        System.out.println(GAME_WINNER + String.join(", ", winners));
    }

    public void printResultsByOrder(List<Car> cars) {
        StringBuilder stringBuilderByOrder = new StringBuilder();
        for (Car car : cars) {
            stringBuilderByOrder.append(car.toString());
        }
        System.out.println(stringBuilderByOrder);
    }
}
