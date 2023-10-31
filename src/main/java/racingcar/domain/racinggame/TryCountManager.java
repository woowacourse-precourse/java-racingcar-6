package racingcar.domain.racinggame;

import racingcar.domain.racinggame.trycountfactory.TryCountFactory;

public class TryCountManager {
    private int tryCount;
    private final TryCountFactory tryCountFactory;

    public TryCountManager(TryCountFactory tryCountFactory) {
        this.tryCountFactory = tryCountFactory;
    }

    public void makeTryCount() {
        setTryCount(tryCountFactory.createTryCount());
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void invokeForTryCount(Runnable runnable) {
        while (tryCount-- > 0) {
            runnable.run();
        }
    }
}
