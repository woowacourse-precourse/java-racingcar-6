package racingcar.domain;

public class GameManager {

    public void startRacingGame() {
        Output.printCarInputMessage();
        String[] carArray = Input.getCarsByUser();
        Cars cars = new Cars(carArray);
        Output.printTryCountInputMessage();
        TryCount tryCount = new TryCount(Input.getTryCountByUser());
        RacingGame racingGame = new RacingGame(cars, tryCount);

        Output.printResultMessage();
        racingGame.run();
    }
}
