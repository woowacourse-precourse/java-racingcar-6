package racingcar.view;

import java.util.List;
import java.util.Optional;
import racingcar.dto.Car;

public class OutputView {

    /* 자동차별 라운드 결과 출력 */
    public static void printStatusOfRaceCar(Car car) {
        System.out.print(car.name() + " : ");
        for (int i = 0; i < car.position(); i++) {
            System.out.print("-");
        }
        System.out.println();
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

            for (Car car : carsWithMaxPosition) {
                System.out.print(car.name() + ",");
            }
        }
        System.out.println();
    }
}
