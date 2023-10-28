package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.RoundValidator;
import racingcar.view.InputView;

public class GameUtil {

    private static int MAX_NUM = 9;
    private static int MIN_NUM = 0;

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public static int setTryCount(){
        RoundValidator roundValidator = new RoundValidator(InputView.getRound());
        return Integer.parseInt(roundValidator.tryCount);
    }
}
