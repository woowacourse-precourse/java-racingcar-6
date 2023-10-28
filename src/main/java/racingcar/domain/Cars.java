package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> elements = new ArrayList<>();

    public Cars(List<String> names) {
        names.forEach(name -> elements.add(new Car(name)));
    }

    public void race() {
        elements.forEach(Car::race);
    }

    public String getRacingResult() {
        StringBuilder sb = new StringBuilder();
        elements.forEach(car -> sb.append(car.getRaceResult()));
        return sb.toString();
    }

    public List<String> getWinner() {
        int max = calculateMaxPosition();
        return elements.stream()
                .filter(car -> car.isSamePosition(max))
                .map(Car::getName)
                .toList();
    }

    private int calculateMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        elements.forEach(element -> positions.add(element.getPosition()));
        return Collections.max(positions);
    }
}
