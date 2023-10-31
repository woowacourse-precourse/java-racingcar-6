package racingcar.service;

import java.util.List;
import racingcar.constant.StringConstant;
import racingcar.domain.CarList;
import racingcar.domain.GameCount;
import racingcar.util.UserUtil;

public class GameService {

    private CarList carList;
    private GameCount gameCount;

    public void createCarList() {
        String userInput = UserUtil.getUserInput();
        carList = CarList.from(userInput);
    }

    public void createGameCount() {
        String userInput = UserUtil.getUserInput();
        gameCount = GameCount.from(userInput);
    }

    public void playGame() {
        carList.printGameProceed(gameCount.convertStrToInt());
    }

    public void printWinner(){
        System.out.println(String.join(StringConstant.DIVISION_STANDARD.getMessage(), findWinner()));
    }

    private List<String> findWinner() {
        return carList.findWinner();
    }
}
