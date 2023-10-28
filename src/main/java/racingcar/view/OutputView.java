package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    private final String START_PRINT_RESULT_MESSAGE = "실행결과";
    private final String WINNERS_MESSAGE = "최종 우승자 : ";

    public void printResultMessage() {
        System.out.println(START_PRINT_RESULT_MESSAGE);
    }

    public void printCarsPosition(Cars cars) {
        cars.getCarList()
                .forEach(this::printCarInformation);
        System.out.println();
    }

    private void printCarInformation(Car car) {
        System.out.println(car.getCarName() + " : " + car.getPositionToString());
    }

    public void printWinners(Cars cars) {
        System.out.println(WINNERS_MESSAGE + cars.WinnersToString());
    }
}
