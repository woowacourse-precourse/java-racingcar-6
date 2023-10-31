package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResultsPresenter {
    public void printRaceProcess(List<Car> cars) {
        for (Car car : cars) {
            String sb = car.getName()
                    + " : "
                    + "-".repeat(Math.max(0, car.getPosition()));
            System.out.println(sb);
        }
        System.out.println("");
    }


    public void printWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);

        String winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }
}