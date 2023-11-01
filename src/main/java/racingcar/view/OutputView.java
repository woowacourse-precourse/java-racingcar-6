package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String CAR_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_NAME_MESSAGE = " : ";
    private static final String CAR_POSITION_MESSAGE = "-";
    private static final String WINNER_CAR_NAME_MESSAGE = "최종 우승자";

    public void printResultMessage() {
        System.out.println(CAR_RESULT_MESSAGE);
    }

    public void printCarPositionMessage(Car car) {
        System.out.println(car.getCarName() + CAR_NAME_MESSAGE + CAR_POSITION_MESSAGE.repeat(car.getPosition()));
    }

    public void printLineChange(){
        System.out.println();
    }

    public void printWinnerCarName(List<String> names) {
        System.out.print(WINNER_CAR_NAME_MESSAGE + CAR_NAME_MESSAGE);
        for (int i = 0; i < names.size() - 1; i++) {
            System.out.print(names.get(i) + ", ");
        }
        System.out.print(names.get(names.size() - 1));
    }
}
