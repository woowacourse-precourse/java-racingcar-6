package racingcar.view;

import java.util.List;

public class RaceProgressView {

    public static void printRaceProgress(List<String> carInfo) {
        for (String carInfoStr : carInfo) {
            System.out.println(carInfoStr);
        }
    }
}
