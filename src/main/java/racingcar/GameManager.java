package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Random;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameManager {
    GameElements gameElements = new GameElements();
    Input input = new Input();

    public void gameSetting() {
        Output.printInputCarMessage();
        gameElements.carNamesSetting(input.getCarNameList());

        Output.printInputTryCountMessage();
        gameElements.tryCountSetting(input.getTryCount());
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
