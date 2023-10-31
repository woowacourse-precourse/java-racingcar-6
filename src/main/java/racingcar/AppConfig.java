package racingcar;

import racingcar.service.Dice;
import racingcar.service.Judgement;
import racingcar.service.impl.JudgementImpl;
import racingcar.service.impl.RandomDiceImpl;

public class AppConfig {
    public static final int MIN_DICE_NUMBER = 0;
    public static final int MAX_DICE_NUMBER = 9;
    public static final int MAX_CARNAME_LENGTH = 5;
    public static final int MINIMUM_GO_NUMBER = 4;

    public Dice dice() {
        return new RandomDiceImpl();
    }

    public Judgement judgement() {
        return new JudgementImpl();
    }
}
