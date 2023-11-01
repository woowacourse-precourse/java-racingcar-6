package racingcar.View;

import static racingcar.Constants.PrintMessage.COLON;
import static racingcar.Constants.PrintMessage.DELIMITER;
import static racingcar.Constants.PrintMessage.EXECUTE_RESULT;
import static racingcar.Constants.PrintMessage.FINAL_WINNER;
import static racingcar.Constants.PrintMessage.HYPHEN;
import static racingcar.Constants.PrintMessage.INPUT_NAME;
import static racingcar.Constants.PrintMessage.INPUT_TRYNUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;

public class ConsolePrint {

    public static String readCars() {
        System.out.println(INPUT_NAME.getMessage());
        return Console.readLine();
    }

    public static String readTryNum() {
        System.out.println(INPUT_TRYNUMBER.getMessage());
        return Console.readLine();
    }

    public static void printOpening() {
        System.out.println(EXECUTE_RESULT.getMessage());
    }

    public static void printRace(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + COLON.getMessage());
            printDistance(car);
        }

        System.out.println();
    }

    public static void printDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(HYPHEN.getMessage());
        }

        System.out.println();
    }

    public static void printWinner(List<Car> carList) {
        int maxDistance = carList.get(0).getDistance();

//        To check if there are multiple winners
        List<String> winners = carList.stream()
                .takeWhile(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print(FINAL_WINNER.getMessage() + String.join(DELIMITER.getMessage(), winners));
    }

}
