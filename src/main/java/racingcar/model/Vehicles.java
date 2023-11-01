package racingcar.model;

import java.util.List;
import racingcar.util.NumberGenerator;

public interface Vehicles {

    void moveAll(NumberGenerator numberGenerator);

    List<Vehicle> getVehicles();

    List<String> getWinner();
}
