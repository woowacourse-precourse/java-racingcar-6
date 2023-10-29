package racingcar.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.dto.Car;

public class OutputView {

    /* 자동차별 라운드 결과 출력 */
    public static void printStatusOfRaceCar(Car car) {
        System.out.println(car.name() + " : " + "-".repeat(car.position()));
    }

    /* 최종 우승자 출력 */
    public static void printGameWinner(List<Car> listCar) {
        System.out.print("최종 우승자 : ");
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
