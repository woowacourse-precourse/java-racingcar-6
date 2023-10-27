package racingcar.model;

import java.util.List;
import java.util.Map;

public interface RacingGame {

    void move();

    Map<Vehicle, Position> getVehiclePositionMap();

    List<String> getWinner();
}
