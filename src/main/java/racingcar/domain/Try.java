package racingcar.domain;

public class Try {

    private final int COUNT_CRITERION = 1;

    private int count;

    public Try(int count) {
        validateCountValue(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void tryRace() {
        this.count--;
    }

    public boolean isRaceOver() {
        return this.count == 0;
    }

    public void validateCountValue(int count) {
        if (count < COUNT_CRITERION) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }
    }

}
