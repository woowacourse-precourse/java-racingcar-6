package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.dto.CarDTO;
import racingcar.model.dto.WinnerDTO;

public class OutputView {
    private static final String TRIAL_START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printTrialStartMessage() {
        System.out.println(TRIAL_START_MESSAGE);
    }

    private static void printCarStatus(CarDTO carDTO) {
        System.out.println(carDTO);
    }

    private static void printSeparatorForEveryTrial() {
        System.out.println();
    }

    public static void printCarsStatus(Cars cars) {
        for (Car car : cars) {
            printCarStatus(car.toCarDTO());
        }
        printSeparatorForEveryTrial();
    }

    public static void printWinners(WinnerDTO winnerDTO) {
        System.out.println(WINNER_MESSAGE + winnerDTO);
    }
}
