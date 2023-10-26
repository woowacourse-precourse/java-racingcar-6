package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    private final String START_PRINT_RESULT_MESSAGE = "실행결과";

    public void printResultMessage() {
        System.out.println(START_PRINT_RESULT_MESSAGE);
    }

    public void printCarsPosition(Cars cars) {
        cars.getCarList().stream().forEach(this::printCarInformation);
        System.out.println();
    }

    private void printCarInformation(Car car) {
        System.out.println(car.getCarName() + " : " + car.getPositionToString());
    }
}
