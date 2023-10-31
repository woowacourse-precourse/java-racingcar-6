package racingcar.service;

import java.util.List;
import racingcar.domain.CarList;
import racingcar.util.UserUtil;
import racingcar.validation.GameCountValidator;

public class GameService {

    private final String DIVISION_STANDARD = ",";

    private final GameCountValidator gameCountValidator;

    private int gameCount;
    private CarList carList;

    public GameService(GameCountValidator gameCountValidator) {
        this.gameCountValidator = gameCountValidator;
    }

    public void getCarList() {
        String userInput = UserUtil.getUserInput();

        carList = CarList.of(userInput);
    }

    public void getGameCount() {
        String userInput = UserUtil.getUserInput();
        gameCountValidator.validateGameCount(userInput);
        gameCount = Integer.parseInt(userInput);
    }

    public void playGame() {
        carList.playGame(gameCount);
    }

    public void printWinner(){
        System.out.println(String.join(DIVISION_STANDARD, findWinner()));
    }

    private List<String> findWinner() {
        return carList.findWinner();
    }
}
