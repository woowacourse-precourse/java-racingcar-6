package racingcar.service;

import java.util.List;
import racingcar.domain.CarList;
import racingcar.domain.GameCount;
import racingcar.util.UserUtil;
import racingcar.validation.GameCountValidator;

public class GameService {

    private final String DIVISION_STANDARD = ",";

    private CarList carList;
    private GameCount gameCount;

    public void createCarList() {
        String userInput = UserUtil.getUserInput();
        carList = CarList.of(userInput);
    }

    public void createGameCount() {
        String userInput = UserUtil.getUserInput();
        gameCount = GameCount.from(userInput);
    }

    public void playGame() {
        carList.playGame(gameCount.getCount());
    }

    public void printWinner(){
        System.out.println(String.join(DIVISION_STANDARD, findWinner()));
    }

    private List<String> findWinner() {
        return carList.findWinner();
    }
}
