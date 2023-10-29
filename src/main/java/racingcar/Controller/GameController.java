package racingcar.Controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import racingcar.Model.CarModel;
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

        for(int i = 0; i< gameModel.getCoinNumber();i++){

            throwDiceAndGoForward();
        }
    }

    private void throwDiceAndGoForward() {

        int dice;
        ArrayList<CarModel> carModels = carController.getCarModelList();
        CarModel nowCar;

        for(int i = 0; i<gameModel.getCarNumber();i++){

            dice=pickNumberInRange(0,9);
            nowCar = carModels.get(i);

            carController.goForward(nowCar,dice);
        }
    }

}
