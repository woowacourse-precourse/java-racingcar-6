package racingcar.game.renderer;

import static java.util.stream.Collectors.joining;

import java.util.List;
import racingcar.game.domain.Position;
import racingcar.game.domain.RacingCar;

public class SimpleRacingCarGameRenderer implements RacingCarGameRenderer {

    @Override
    public String renderCars(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> car.render(this))
                .collect(joining("\n"));
    }

    @Override
    public String renderCar(String name, Position position) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s : ", name));
        for (int i = 0; i < position.getX(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }

}
