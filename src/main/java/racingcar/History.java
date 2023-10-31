package racingcar;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record History(Map<String, Integer> nameAndPosition) {
    public static History makeHistory(List<Car> carList) {
        Map<String, Integer> carsAndPosition = new HashMap<>();

        for (Car c : carList) {
            carsAndPosition.put(c.getName(), c.getPosition());
        }

        return new History(carsAndPosition);
    }
}
