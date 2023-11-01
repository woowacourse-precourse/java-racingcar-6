package racingcar.domain;

public class RaceCount {

    private int raceCount;

    public RaceCount(String playerInput) {
        validateCounts(playerInput);
        this.raceCount = Integer.parseInt(playerInput);
    }

    public int getCount() {
        return raceCount;
    }

    private void validateCounts(String playerInput) {
        try {
            int count = Integer.parseInt(playerInput);
            if (count < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다. 자동차 경주 게임을 종료합니다.");
        }
    }
}
