package racingcar.model;

import racingcar.util.NumberGenerator;

public interface Vehicle {

    boolean canMove(NumberGenerator numberGenerator);

    String getName();
}
