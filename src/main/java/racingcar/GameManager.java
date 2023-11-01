package racingcar;

import java.util.List;

public class GameManager {

    private Player player;
    private RacingCarGame racingCarGame;
    private OutputView outputView;

    public GameManager() {
        player = new Player();
        racingCarGame = new RacingCarGame();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printNameMessage();
        String carName = player.inputCarName();

        outputView.printCountMessage();
        int movingCount = player.inputMovingCount();

        racingCarGame.splitCarName(carName);
        racingCarGame.saveMovingCount(movingCount);

        racingCarGame.createCar();

        outputView.printResultMessage();

        while (true) {
            List<Car> carList = racingCarGame.getCarList();

            for (int i = 0; i < carList.size(); i++) {
                Car car = carList.get(i);
                car.raiseMovingCount();
            }

            racingCarGame.saveCarMovingCount();

            outputView.printRacingCarGameResult(racingCarGame.getCarNameList(), racingCarGame.getCarMovingCountList());

            if (racingCarGame.isGameOver()) {
                outputView.printWinnerMessage();
                System.out.println(racingCarGame.getWinnerName());
                break;
            }
        }

    }
}
