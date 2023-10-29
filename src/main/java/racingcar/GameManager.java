package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameManager {
    GameElements gameElements = GameElements.INSTANCE;
    Input input = new Input();


    public void gameSetting() {
        Output.printInputCarMessage();
        gameElements.carNamesSetting(input.getCarNameList());
        gameElements.insertCarMap();

        Output.printInputTryCountMessage();
        gameElements.tryCountSetting(input.getTryCount());
    }



    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
