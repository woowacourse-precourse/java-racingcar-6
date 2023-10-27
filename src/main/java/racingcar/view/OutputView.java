package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarDto;

public class OutputView {

//    public static void printCarStatus(List<Car> cars) {
//        for (Car car : cars) {
//            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
//        }
//        System.out.println();
//    }

    public static void printCarStatus(List<CarDto> carStatus) {
        for (CarDto status : carStatus) {
            System.out.println(status.getDisplayStatus());
        }
        System.out.println();
    }

    public static void announceWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}