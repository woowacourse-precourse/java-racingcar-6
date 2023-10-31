package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceCar {
    public static List<String> cars = new ArrayList<>();
    public static List<String> moveDistance = new ArrayList<>();

    public RaceCar(List<String> carName) {
        for (int i = 0; i < carName.size(); i++) {
            cars.add(carName.get(i));
            moveDistance.add("");
        }
    }

    public void forward(List<Integer> randomNumber) {
        for (int i = 0; i < cars.size(); i++) {
            if (randomNumber.get(i) >= 4) {
                moveDistance.set(i, moveDistance.get(i) + "-");
            }
        }
    }

}
