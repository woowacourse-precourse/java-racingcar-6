package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.Car;
import racingcar.global.Announcement;

public class RaceIO {

    // input methods
    public static List<String> getCarNameAsList() {
        String carName = Console.readLine();
        return Arrays.asList(carName.split(Race.CAR_NAME_DELIMITER));
    }

    public static String getCount() {
        return Console.readLine();
    }

    // output methods
    public static void announceGetCarName() {
        System.out.println(Announcement.GET_CAR_NAME);
    }

    public static void announceGetCount() {
        System.out.println(Announcement.GET_COUNT);
    }

    public static void announceStartPrintResult() {
        System.out.println(Announcement.START_PRINT_RESULT);
    }

    public static void printInterimResult(List<Car> cars) {
        cars.forEach(car -> {
            String individualResult = Announcement.currentState(car);
            System.out.println(individualResult);
        });
        System.out.println("");
    }

    public static void printWinners(String winners) {
        System.out.println(Announcement.finalResult(winners));
    }
}
