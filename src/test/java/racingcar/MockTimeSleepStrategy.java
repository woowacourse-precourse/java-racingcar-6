package racingcar;

public class MockTimeSleepStrategy implements TimeSleepStrategy {
    private final static MockTimeSleepStrategy INSTANCE = new MockTimeSleepStrategy();

    private final static int SLEEP_MILLISECONDS = 0;

    private MockTimeSleepStrategy(){
    }

    public static MockTimeSleepStrategy getInstance() {
        return INSTANCE;
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
