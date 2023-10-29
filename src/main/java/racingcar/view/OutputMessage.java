package racingcar.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputMessage {
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printMovingCarNames(List<Car> cars) {
        for (Car car : cars) {
            String forwardText = "-".repeat(car.getMoveNumber());
            System.out.println(car.getName() + " : " + forwardText);
        }

    }

    public List<Car> printWinnerAfterRaceCompletion(List<Car> cars) {
        List<Car> maxMoveNumberCars = cars.stream().filter(car ->
                car.getMoveNumber() == cars.stream().max(Comparator.comparing(Car::getMoveNumber)).get().getMoveNumber()
        ).collect(Collectors.toList());

        System.out.print(FINAL_WINNER);

        List<String> names = maxMoveNumberCars.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(", ", names));
        return maxMoveNumberCars;
    }

}
