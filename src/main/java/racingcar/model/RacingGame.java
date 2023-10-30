package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.Controller;
import racingcar.controller.Validator;
import racingcar.view.OutputView;

public class RacingGame {
    List<String> playerName = new ArrayList<>();
    List<Integer> playerDistance = new ArrayList<>();
    Integer count;
    Integer winnerDistance = 0;

    public void startGame() {
        OutputView.askCarName();
        this.playerName = Controller.splitName(OutputView.readCarName());
        Validator.isRightName(playerName);
        setStartPoint();
        OutputView.askCount();
        this.count = Controller.readCount();
        OutputView.startRace();
        for (int i = 0; i < this.count; i++) {
            moveForward();
            OutputView.printResult(playerName, playerDistance);
        }
        OutputView.printWinner(playerName, playerDistance, winnerDistance);
    }

    private void setStartPoint() {
        for (int i = 0; i < playerName.size(); i++) {
            playerDistance.add(i, 0);
        }
    }

    private void moveForward() {
        for (int i = 0; i < playerName.size(); i++) {
            int randomNumber = Controller.makeRandomNum();
            if (Validator.isFourOrMore(randomNumber)) {
                playerDistance.set(i, playerDistance.get(i) + 1);
            }
            if (winnerDistance < playerDistance.get(i)) {
                winnerDistance = playerDistance.get(i);
            }
        }
    }
}
