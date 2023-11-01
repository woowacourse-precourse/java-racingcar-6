package racingcar.model;

import racingcar.controller.Controller;
import racingcar.controller.Validator;
import racingcar.view.View;

public class RacingGame {
    CarName carName;
    CarDistance carDistance;
    Integer count;
    Integer winnerDistance = 0;

    public void startGame() {
        View.askCarName();
        carName = CarName.makeCarName(View.readCarName());
        carDistance = CarDistance.makeCarDistance();
        carDistance.setStartPoint(carName.getSize());
        View.askCount();
        this.count = Controller.readCount(View.readInput());
        View.startRace();
        for (int i = 0; i < this.count; i++) {
            moveForward();
            View.printResult(carName.getCarName(), carDistance.getCarDistance());
        }
        View.printWinner(carName.getCarName(), carDistance.getCarDistance(), winnerDistance);
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
