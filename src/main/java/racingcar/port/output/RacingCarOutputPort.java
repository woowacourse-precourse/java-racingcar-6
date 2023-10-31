package racingcar.port.output;

import java.util.List;

public interface RacingCarOutputPort {
    List<String> getCarNames();
    int getTryCount();
}
