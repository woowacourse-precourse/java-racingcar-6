package racingcar.mock;

import racingcar.TimeSleepStrategy;

public class MockTimeSleepStrategy implements TimeSleepStrategy {
    private final static MockTimeSleepStrategy instance = new MockTimeSleepStrategy();

    private final static int SLEEP_MILLISECONDS = 0;

    private MockTimeSleepStrategy(){
    }

    public static MockTimeSleepStrategy getInstance() {
        return instance;
    }

    @Override
    public void timeSleep() {
        try {
            Thread.sleep(SLEEP_MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
