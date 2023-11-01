package racingcar.domain.game;

public class Rounds {

    private int remainRound;

    public Rounds(int remainRound) {
        this.validateIsPositive(remainRound);
        this.remainRound = remainRound;
    }

    private void validateIsPositive(int remainRound) {
        if (remainRound < 0) {
            throw new IllegalArgumentException("회수는 음수일 수 없습니다.");
        }
    }

    public void next() {
        remainRound -= 1;
    }

    public boolean isEnd() {
        return remainRound <= 0;
    }
}
