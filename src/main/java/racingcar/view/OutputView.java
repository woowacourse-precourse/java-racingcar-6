package racingcar.view;

import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class OutputView {
    public static void displayTitle() {
        System.out.println(GameMessage.OUTPUT_EXECUTION_RESULTS.getMessage());
    }

    public static void displayRacingSituation(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName());
            System.out.print(GameMessage.OUTPUT_COLON.getMessage());
            displayForward(car);
        }
        System.out.println();
    }

    public static void displayForward(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(GameMessage.OUTPUT_FORWARD.getMessage());
        }
        System.out.println();
    }

    public static void displayWinner(Winners winners) {
        System.out.print(GameMessage.OUTPUT_WINNER_ANNOUNCEMENT.getMessage());
        int size = winners.getWinners().size();

        System.out.print(winners.getWinners().get(0));

        for (int i = 1; i < size; i++) {
            System.out.print(GameMessage.OUTPUT_DIVISION.getMessage());
            System.out.print(winners.getWinners().get(i));
        }
    }
}
