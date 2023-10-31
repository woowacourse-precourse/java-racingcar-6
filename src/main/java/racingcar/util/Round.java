package racingcar.util;

import racingcar.viewer.Error_Check;

public class Round {
    private static final int INCREASED_ROUND = 1;
    private final int round_number;
    private int round_index;

    public Round(int round_number, int round_index) {
        Error_Check.Round(round_number, round_index);
        this.round_number = round_number;
        this.round_index = round_index;
    }
    public int Increase() {
        this.round_index += INCREASED_ROUND;
        Error_Check.Round(this.round_number, this.round_index);
        return this.round_index;
    }

    public int Get_Round_index() {
        return this.round_index;
    }

    public int Get_Round_Remaining() {

        return this.round_number-this.round_index;
    }
}