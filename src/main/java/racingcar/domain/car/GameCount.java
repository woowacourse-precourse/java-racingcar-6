package racingcar.domain.car;

public class GameCount {

    private static final int MIN_GANE_COUNT = 1;
    private static final int MAX_GAME_COUNT = 20;
    private final int count;

    public GameCount(int count) {
        validate(count);
        this.count = count;
    }

    public void validate(int count){
        if(count > MAX_GAME_COUNT || count < MIN_GANE_COUNT){
            throw new IllegalArgumentException("경주 진행 횟수는 1회 이상, 20회 이하여야 합니다.");
        }
    }
}
