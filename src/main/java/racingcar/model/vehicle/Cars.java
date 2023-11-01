package racingcar.model.vehicle;

import java.util.List;

public sealed interface Cars permits RacingCars {
    Cars applyNames(final List<String> names);

    List<Integer> moveCars();

    List<String> getSingleRoundResult();

    List<String> getNamesForTest();

    List<String> getWinnerName();
}