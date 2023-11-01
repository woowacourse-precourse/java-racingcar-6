package racingcar.support;

import domain.CarEngine;

public class StubCarEngine implements CarEngine {

    private final boolean canGoAlways;

    public StubCarEngine(final boolean canGoAlways) {
        this.canGoAlways = canGoAlways;
    }

    public StubCarEngine() {
        this(true);
    }

    @Override
    public boolean canMoveForward() {
        return canGoAlways;
    }
}
