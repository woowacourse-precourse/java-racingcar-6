package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.model.Cars;
import racingcar.model.Game;

public class MainView {
    private final CarController carController;
    private final GameController gameController;

    public MainView(CarController carController, GameController gameController) {
        this.carController = carController;
        this.gameController = gameController;
    }

    private Cars carSetting() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new Cars(carController.makeCar(readLine()));
    }

    private Game gameSetting() {
        System.out.println("시도할 회수는 몇회인가요?");
        return gameController.makeGame(readLine());
    }

    public void run() {
        GameView gameView = new GameView(gameController, carSetting(), gameSetting());
        gameView.run();
    }
}
