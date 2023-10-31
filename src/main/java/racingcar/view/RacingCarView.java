package racingcar.view;

import static racingcar.utils.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class RacingCarView {

    public static String[] inputCarNames() {
        System.out.println(ViewFormat.INPUT_CARNAME.getFormatContent());
        String cars = inputStringLine();

        return cars.split(",");
    }

    public static int inputGameCount() {
        System.out.println(ViewFormat.INPUT_COUNT.getFormatContent());
        String count = inputStringLine();

        gameCountValidate(count);

        return Integer.parseInt(count);
    }

    public static void outputRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String graphicOfDistance = ViewFormat.DISTANCE
                    .getFormatContent()
                    .repeat(car.getDistance());
            System.out.println(car.getName() + " : " + graphicOfDistance);
        }
        System.out.println();
    }

    public static void outputWinners(List<Car> cars) {
        int maxOfDistance = cars.stream()
                .map(Car::getDistance)
                .mapToInt(car -> car)
                .max()
                .orElse(Integer.MIN_VALUE);

        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == maxOfDistance)
                .map(Car::getName)
                .toList();

        System.out.print("최종 우승자 : " + String.join(", ",winners));
    }

    private static String inputStringLine() {
        return Console.readLine();
    }
}
