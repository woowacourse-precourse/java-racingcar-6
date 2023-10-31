package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.util.MessageConst;

public class OutputView {
    private static final String WINNER_MSG = "최종 우승자 : ";
    public static final String DELIMITER = ",";

    public void printResultMessage() {
        System.out.println(MessageConst.OUTPUT_RESULT_MSG);
    }

    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + drawPosition(car.getPosition()));
        }
        System.out.println();
    }

    private String drawPosition(int position) {
        return MessageConst.DISTANCE_MARK.repeat(position);
    }

    public void printFinalWinner(Cars cars) {
        Winners winners = new Winners(cars);
        System.out.println(WINNER_MSG + String.join(DELIMITER, winners.getFinalWinnerNames()));
    }

}
