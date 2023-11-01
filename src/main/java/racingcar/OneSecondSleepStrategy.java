package racingcar;

import racingcar.constant.FixedNumber;

public class OneSecondSleepStrategy implements TimeSleepStrategy {
    private final static OneSecondSleepStrategy instance = new OneSecondSleepStrategy();

    private OneSecondSleepStrategy(){
    }

    public static OneSecondSleepStrategy getInstance() {
        return instance;
    }

    @Override
    public void timeSleep() {
        try {
            Thread.sleep(FixedNumber.ROUND_SLEEP_MILLISECONDS.getValue());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
