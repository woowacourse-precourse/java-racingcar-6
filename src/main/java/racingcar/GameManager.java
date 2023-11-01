package racingcar;

import java.util.List;

public class GameManager {

    private Player player;
    private RacingCarGame racingCarGame;
    private OutputView outputView;
    private String carName;
    private int movingCount;

    public GameManager() {
        player = new Player();
        racingCarGame = new RacingCarGame();
        outputView = new OutputView();
        carName = "";
        movingCount = 0;
    }

    public void start() {
        inputInformation();
        makeCar();
        setMovingCount();
        doGame();
    }

    public void inputInformation() {
        outputView.printNameMessage();
        carName = player.inputCarName();

        outputView.printCountMessage();
        movingCount = player.inputMovingCount();
    }

    public void makeCar() {
        racingCarGame.createCar(carName);
    }

    public void setMovingCount() {
        racingCarGame.saveMovingCount(movingCount);
    }

    public void getCarMovingCount() {
        List<Car> carList = racingCarGame.getCarList();

        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.raiseMovingCount();
        }

        racingCarGame.setCarMovingCountManager();
    }

    public boolean checkGameOver() {
        if (racingCarGame.isGameOver()) {
            outputView.printWinnerMessage();
            System.out.println(racingCarGame.getWinnerName());
            return true;
        }
        return false;
    }

    public void doGame() {
        outputView.printResultMessage();
        while (true) {
            getCarMovingCount();
            CarNameManager carNameManager = racingCarGame.getCarNameManager();
            CarMovingCountManager carMovingCountManager = racingCarGame.getCarMovingCountManager();
            outputView.printRacingCarGameResult(carNameManager.getCarNameList(),
                    carMovingCountManager.getCarMovingCountList());

            if (checkGameOver()) {
                break;
            }
        }
    }

}
