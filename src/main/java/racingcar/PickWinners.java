package racingcar;

import java.util.ArrayList;
import java.util.List;

public class PickWinners {
    public static List<String> pick(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].steps > max)
                max = cars[i].steps;
        }

        for(int i = 0; i < cars.length; i++){
            if(cars[i].steps == max)
                winners.add(cars[i].name);
        }
        return winners;
    }
}
