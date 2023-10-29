package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.MessageConst;

public class OutputView {
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
}
