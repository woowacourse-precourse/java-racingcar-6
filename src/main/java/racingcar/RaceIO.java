package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
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
}
