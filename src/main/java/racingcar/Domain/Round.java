package racingcar.Domain;

public class Round {
    private int count;
    private static final int MIN_ROUND_COUNT = 1;

    private Round(int count) {
        validateRoundCount(count);
        this.count = count;
    }
    public static Round of(int count) {
        return new Round(count);
    }
    public int getCount(){
        return count;
    }
    private void validateRoundCount(int count) {
        if (count < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("라운드 실행 횟수는 1회 이상이어야 합니다.");
        }
    }
}
