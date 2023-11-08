package racingcar.domain.view.printer;

import java.util.List;
import racingcar.domain.entity.Car;

public class IntermediateCoursePrinter {
    private static final String CAR_NAME_AND_RACE_INFORMATION_SEPARATOR = " : ";
    private static final String RACE_INFORMATION = "-";
    private static final String TRY_NUMBER_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";


    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + CAR_NAME_AND_RACE_INFORMATION_SEPARATOR);
            printLocation(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printLocation(Car car) {
        for (int i = 0; i < car.getLocation().getInteger(); i++) {
            System.out.print(RACE_INFORMATION);
        }
    }

    public static void printChallenge() {
        System.out.println(TRY_NUMBER_REQUEST_MESSAGE);
    }
}
