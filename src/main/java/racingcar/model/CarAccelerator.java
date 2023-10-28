package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarAccelerator implements WrappedRandoms {

    private static final int MINIMUM_RANGE_OF_RANDOM_NUMBER= 0;
    private static final int MAXIMUM_RANGE_OF_RANDOM_NUMBER= 9;
    private static final int ACCELERATE_CRITERION= 4;

    private static WrappedRandoms INSTANCE;
    private static final WrappedRandoms Randoms = new RealRandoms();

    public boolean shouldAccelerate() {
        if (INSTANCE.pickNumberInRange(MINIMUM_RANGE_OF_RANDOM_NUMBER,
            MAXIMUM_RANGE_OF_RANDOM_NUMBER) >=ACCELERATE_CRITERION) {
            return true;
        }

        return false;
    }

    public static void setFakeRandoms() {
        INSTANCE= new FakeRandoms();
    }

    public static void rollback() {
        INSTANCE= Randoms;
    }

    @Override
    public int pickNumberInRange(int minimumOfRange, int MaximumOfRange) {
        return -1;
    }

    private static final class RealRandoms implements WrappedRandoms {

        @Override
        public int pickNumberInRange(int minimumOfRange, int maximumOfRange) {
            return Randoms.pickNumberInRange(maximumOfRange, maximumOfRange);
        }
    }

    private static final class FakeRandoms implements WrappedRandoms {

        private static final int FAIL_NUMBER= 3;

        @Override
        public int pickNumberInRange(int minimumOfRange, int maximumOfRange) {
            return FAIL_NUMBER;
        }
    }
}
