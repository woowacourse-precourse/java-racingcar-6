package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    private int dice;

    public Dice() {
        this.dice = Randoms.pickNumberInRange(0, 9);
    }

    public int getDice() {
        return dice;
    }
}
