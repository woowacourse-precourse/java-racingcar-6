package racingcar.Controller;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.Service.RacingcarService;
import racingcar.View.UserInputView;

public class RacingcarController {
    private final UserInputView userInputView = new UserInputView();
    private final RacingcarService racingcarService = new RacingcarService();

    public void startGame() {
        List<Car> carList = userInputView.InputCarNames();
        int goalRound = userInputView.InputGoalRound();

        racingcarService.initailizeGame(carList, goalRound);

    }
}
