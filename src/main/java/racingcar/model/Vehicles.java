package racingcar.model;

import java.util.List;
import java.util.Map;
import racingcar.util.NumberGenerator;

public interface Vehicles {

    void moveAll(NumberGenerator numberGenerator);

    Map<String, Integer> getResult();

    List<String> getWinner();
}
