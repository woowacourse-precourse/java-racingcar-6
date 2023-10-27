package racingcar.model;

import java.util.List;
import java.util.Map;
import racingcar.util.NumberGenerator;

public interface RacingGame {

    void move(NumberGenerator numberGenerator);

    Map<Vehicle, Position> getVehiclePositionMap();

    List<String> getWinner();
}
