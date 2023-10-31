package racingcar.model;

import racingcar.util.NumberGenerator;

public interface Vehicle {

    void move(NumberGenerator numberGenerator);

    String getName();

    int getPosition();
}
