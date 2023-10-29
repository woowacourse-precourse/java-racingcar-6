package racingcar.Controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.Model.GameModel;

public class GameController {

    private final GameModel gameModel;
    private final CarController carController;

    public GameController(GameModel gameModel, CarController carController) {
        this.gameModel = gameModel;
        this.carController = carController;
    }


    public void gameStart(){

        String[] carList;
        int coinNumber;

        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        carList = readLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        coinNumber = Integer.parseInt(readLine());

        gameModel.setCarNumber(carList.length);
        gameModel.setCoinNumber(coinNumber);

        carController.setCarModels(carList);
    }

}
