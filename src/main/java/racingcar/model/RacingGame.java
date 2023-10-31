package racingcar.model;

import racingcar.controller.Controller;
import racingcar.controller.Validator;
import racingcar.view.OutputView;

public class RacingGame {
    CarName carName;
    CarDistance carDistance;
    Integer count;
    Integer winnerDistance = 0;

    public void startGame() {
        OutputView.askCarName();
        carName = carName.makeCarName(OutputView.readCarName());
        carDistance.setStartPoint();
        OutputView.askCount();
        this.count = Controller.readCount(OutputView.readInput());
        OutputView.startRace();
        for (int i = 0; i < this.count; i++) {
            moveForward();
            OutputView.printResult(carName.getCarName(), carDistance.getPlayerDistance());
        }
        OutputView.printWinner(carName.getCarName(), carDistance.getPlayerDistance(), winnerDistance);
    }


    private void moveForward() {
        for (int i = 0; i < carName.getSize(); i++) {
            int randomNumber = Controller.makeRandomNum();
            if (Validator.isFourOrMore(randomNumber)) {
                carDistance.setDistance(i);
            }
            if (winnerDistance < carDistance.getDistanceOf(i)) {
                winnerDistance = carDistance.getDistanceOf(i);
            }
        }
    }
}
