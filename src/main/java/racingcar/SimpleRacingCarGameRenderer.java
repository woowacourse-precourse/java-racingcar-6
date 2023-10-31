package racingcar;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class SimpleRacingCarGameRenderer implements RacingCarGameRenderer {

    public String renderCars(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> car.render(this))
                .collect(joining("\n"));
    }

    public String renderCar(String name, Position position) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s : ", name));
        for (int i = 0; i < position.getX(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
