package racingcar;

public class RoundNumber {

    private final int round_Num;

    public RoundNumber(int round_Num) {
        validate_min_max_round_number(round_Num);
        this.round_Num = round_Num;
    }

    private void validate_min_max_round_number(final int round_Num) {
        if (round_Num < 1 || round_Num > 10) {
            throw new IllegalArgumentException("1 이상, 10 이하의 수를 입력해주세요.");
        }
    }

    public int getRound_Num() {
        return round_Num;
    }
}
