package racingcar;

public class OneSecondSleepStrategy implements TimeSleepStrategy {
    private final static OneSecondSleepStrategy INSTANCE = new OneSecondSleepStrategy();

    private final static int SLEEP_MILLISECONDS = 1000;

    private OneSecondSleepStrategy(){
    }

    public static OneSecondSleepStrategy getInstance() {
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
