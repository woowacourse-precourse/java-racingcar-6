package racingcar;

import java.util.List;

public interface RacingCarGameRenderer {
    String renderCars(List<RacingCar> cars);
    String renderCar(String name, Position position);
}
