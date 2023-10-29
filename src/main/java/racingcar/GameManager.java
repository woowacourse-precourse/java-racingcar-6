package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameManager {
    GameElements gameElements = new GameElements();
    Input input = new Input();


    public void gameSetting() {
        Output.printInputCarMessage();
        gameElements.carNamesSetting(input.getCarNameList());
        insertCarMap();

        Output.printInputTryCountMessage();
        gameElements.tryCountSetting(input.getTryCount());
    }

    private void insertCarMap(){
        for(String carName : gameElements.getCarNameList()){
            gameElements.getCarMap().put(carName, 0);
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
