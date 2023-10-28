package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_START_NOTIFICATION_MESSAGE = "최종 우승자 : ";
    private final String MOVE_NOTIFICATION = "-";

    public void printCarInfo(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(MOVE_NOTIFICATION);
        }

        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }

    public void printWinner(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WINNER_START_NOTIFICATION_MESSAGE);
        for (int i = 0; i < cars.size(); i++) {
            if (i == cars.size() - 1) {
                stringBuilder.append(cars.get(i).getName() + "\n");
            } else {
                stringBuilder.append(cars.get(i).getName() + ", ");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    public void printCarInputMessage() {
        System.out.println(INPUT_CAR_MESSAGE);
    }

    public void printMoveCountInputMessage() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printNewLine() {
        System.out.println();
    }
}
