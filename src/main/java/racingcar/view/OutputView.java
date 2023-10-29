package racingcar.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.dto.Car;

public class OutputView {
    private static final String GAME_FINAL_WINNER = "최종 우승자 : ";

    public static void printStatusOfRaceCar(Car car) {
        System.out.println(car.name() + " : " + "-".repeat(car.position()));
    }

    public static void printGameWinner(List<Car> listCar) {
        System.out.print(GAME_FINAL_WINNER);

        Optional<Integer> maxPosition = listCar.stream()
                .map(Car::position)
                .max(Integer::compareTo);

        if (maxPosition.isPresent()) {
            List<Car> carsWithMaxPosition = listCar.stream()
                    .filter(car -> car.position().equals(maxPosition.get()))
                    .toList();

            String result = carsWithMaxPosition.stream()
                    .map(Car::name)
                    .collect(Collectors.joining(","));

            System.out.println(result);

        }
    }
}
