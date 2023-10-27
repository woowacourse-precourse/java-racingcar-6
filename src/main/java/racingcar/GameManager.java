package racingcar;

import java.util.List;
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
}
