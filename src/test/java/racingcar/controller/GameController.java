package racingcar.controller;

public class GameController {

    public void run() {
        String carNames = GameInputView.getUserCarNames();
        Cars cars = new Cars(carNames);
        int totalRoundNumber = GameInputView.getTotalRoundNumber();

        for (int i=0; i<totalRoundNumber; i++) {
            cars.race();
            GameOutputView.printCarPositions(cars.getPosition());
        }

        GameOutputView.printWinner(cars.getWinners());
    }
}