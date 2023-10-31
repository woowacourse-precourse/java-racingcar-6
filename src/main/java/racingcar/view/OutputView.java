package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.stream.Collectors;

public class OutputView {

    public static final int END_GAME = 0;

    public static void outputResult(Cars cars) {

        System.out.println("실행 결과");

        for (Car car : cars.getCars()) {

            outputCarNameAndPosition(car);
        }
        System.out.println();
    }

    public static void outputWinner(Cars winners) {

        String winnerNames = winners.getCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    private static void outputCarNameAndPosition(Car car) {

        System.out.print(car.getCarName() + " : ");

        for (int i = 0; i <= car.getPosition(); i++) {

            System.out.print("-");
        }
        System.out.println();
    }
}