package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    public static void printCarsPosition(Car car) {
        System.out.println(car.getName() + " : " + car.getPosition());
    }

    public static void printWinnerList(List<Car> winnerList) {

        String winnerString = winnerList.stream()
                .map(Car::getName).collect(Collectors.joining(", ", "최종 우승자 : ", ""));

        System.out.print(winnerString);
    }
}
