package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

public class Output {
    private static final String RESULT_MESSAGE = "\n실행 결과:";

    private Output() {
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinnersName(List<Car> cars) {
        String winnerList = cars.stream()
                .map(Car::getName)
                .map(Name::toString)
                .collect(Collectors.joining(", ", "최종 우승자: ", ""));

        System.out.print(winnerList);
    }

    public static void printCarStatus(Cars cars) {
        StringBuilder carStatus = new StringBuilder();
        cars.getCars().forEach(car -> carStatus.append(car.getName())
                .append(" : ")
                .append("-".repeat(car.getStep()))
                .append("\n"));

        System.out.println(carStatus);
    }
}
