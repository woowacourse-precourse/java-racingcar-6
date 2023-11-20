package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.Iterator;
import java.util.List;

import static racingcar.message.OutputFormat.*;

public class OutputView {
    public void racingNow(RacingCars racingCars) {
        for (Car thisCar : racingCars.getCars()) {
            System.out.printf(RACING_NOW_FORMAT.getFormat(), thisCar.getName(), makeLocationPrinter(thisCar.getLocation()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        System.out.printf(RACING_WINNER_FORMAT.getFormat(), makeWinnerPrinter(cars));
    }

    private String makeLocationPrinter(int location) {
        StringBuilder locationPrint = new StringBuilder();
        for (int i = 0; i < location; i++) {
            locationPrint.append(LOCATION_STEP_FORMAT.getFormat());
        }
        return locationPrint.toString();
    }

    private String makeWinnerPrinter(List<Car> cars) {
        StringBuilder winnerPrinter = new StringBuilder();
        Iterator<Car> Cars = cars.iterator();
        while (Cars.hasNext()) {
            winnerPrinter.append(Cars.next().getName());
            if (Cars.hasNext()) {
                winnerPrinter.append(CAR_NAME_STEP_FORMAT.getFormat());
            }
        }
        return winnerPrinter.toString();
    }

}
