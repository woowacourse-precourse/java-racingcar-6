package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    public void printRacingProcess(Map<String, Integer> carNameAndMoving) {
        for (String carName : carNameAndMoving.keySet()) {
            StringBuilder bar = new StringBuilder();
            for (int i = 0; i < carNameAndMoving.get(carName); i++) {
                bar.append("-");
            }
            System.out.println(carName + " : " + bar);
        }
        System.out.println();
    }

    public void printRacingWinner(Map<String, Integer> carNameAndMoving) {

    }
}