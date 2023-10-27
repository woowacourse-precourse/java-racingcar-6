package racingcar.service;

import java.util.List;

public interface MoveStrategy {
    public List<Boolean> createMovementFlags();
}
