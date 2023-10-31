package racingcar;

import java.util.List;

public class RaceResultView {


    public static void raceResultDisplay(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getCarDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

