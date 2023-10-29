package racingcar.Controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import racingcar.Model.CarModel;
import racingcar.Model.GameModel;

public class GameController {

    private final GameModel gameModel;
    private final ArrayList<CarModel> carModelList;


    public GameController(GameModel gameModel,ArrayList<CarModel> carModelList) {
        this.gameModel = gameModel;
        this.carModelList =carModelList;
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

        setCarModels(carList);

        for(int i = 0; i< gameModel.getCoinNumber();i++){

            throwDiceAndGoForward();
        }

        printDistance();
    }

    private void throwDiceAndGoForward() {

        int dice;
        ArrayList<CarModel> carModels = getCarModelList();
        CarModel nowCar;

        for(int i = 0; i<gameModel.getCarNumber();i++){

            dice=pickNumberInRange(0,9);
            nowCar = carModels.get(i);

            goForward(nowCar,dice);
        }
    }

    public void setCarModels(String[] carList){

        for(String carName : carList){

            carModelList.add(new CarModel(carName));
        }
    }

    public ArrayList<CarModel> getCarModelList() {
        return carModelList;
    }

    public void goForward(CarModel car, int dice){

        if(dice>=4){
            car.goForwardDistance();
        }
    }

    public void printDistance(){

        int distance;
        String carName;
        StringBuilder sb;

        for(CarModel car : carModelList){

            sb = new StringBuilder();
            distance = car.getForwardDistance();
            carName = car.getName();

            sb.append(carName).append(" : ");

            for(int i = 0; i < distance;i++){
                sb.append("-");
            }

            System.out.println(sb);
        }
    }

}
