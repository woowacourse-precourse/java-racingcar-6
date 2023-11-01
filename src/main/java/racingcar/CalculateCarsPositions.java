package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CalculateCarsPositions {
    public static void initializationCarsPositions(List<String> cars) {
        List<Integer> carsPositions = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carsPositions.add(0);
        }
    }
}
