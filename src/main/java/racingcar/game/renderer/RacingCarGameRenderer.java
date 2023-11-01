package racingcar.game.renderer;

import java.util.List;
import racingcar.game.domain.Position;
import racingcar.game.domain.RacingCar;

public interface RacingCarGameRenderer {
    String renderCars(List<RacingCar> cars);

    String renderCar(String name, Position position);
}
