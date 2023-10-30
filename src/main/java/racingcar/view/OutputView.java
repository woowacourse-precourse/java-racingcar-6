package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
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
        int maxDistance = getMaxDistance(cars);
        List<Car> finalWinnerCars = getFinalWinnerCars(cars, maxDistance);
        List<String> finalWinnerNames = getFinalWinnerNames(finalWinnerCars);
        System.out.println(WINNER_MSG + String.join(DELIMITER, finalWinnerNames));
    }

    private static List<String> getFinalWinnerNames(List<Car> finalWinnerCars) {
        return finalWinnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static List<Car> getFinalWinnerCars(Cars cars, int maxDistance) {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxDistance)
                .collect(Collectors.toList());
    }

    private static int getMaxDistance(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
