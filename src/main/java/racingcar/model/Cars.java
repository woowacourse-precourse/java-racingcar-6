package racingcar.model;

import java.util.List;

public sealed interface Cars permits RacingCars {
    Cars applyNames(final List<String> names);

    List<Integer> moveCars();

    List<List<Integer>> moveCarsRepeatedByRound(Integer round);

    List<String> getSingleRoundResult();

    List<String> getNamesForTest();

    List<String> getWinnerName();
}