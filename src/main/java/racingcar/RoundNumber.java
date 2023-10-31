package racingcar;

public class RoundNumber {

    private final int round_Num;

    public RoundNumber(int round_Num) {
        validate_min_max_round_number(round_Num);
        this.round_Num = round_Num;
    }

    private void validate_min_max_round_number(int round_Num) {
        if (round_Num < Constant.MIN_ROUND_NUM || round_Num > Constant.MAX_ROUND_NUM) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MIN_MAX_ROUND_NUM);
        }
    }

    public int getRound_Num() {
        return round_Num;
    }
}
