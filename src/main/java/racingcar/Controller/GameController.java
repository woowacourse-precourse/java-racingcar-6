package racingcar.Controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import racingcar.Model.CarModel;
import racingcar.Model.GameModel;
import racingcar.View.GameView;

public class GameController {

    private final GameModel gameModel;
    private final ArrayList<CarModel> carModelList;
    private final GameView gameView;

    private static final Comparator<CarModel> compareCarDistance = new Comparator<CarModel>() {
        @Override
        public int compare(CarModel o1, CarModel o2) {
            return o1.getForwardDistance() - o2.getForwardDistance();
        }
    };


    public GameController(GameModel gameModel, ArrayList<CarModel> carModelList, GameView gameView) {
        this.gameModel = gameModel;
        this.carModelList = carModelList;
        this.gameView = gameView;
    }


    public void gameStart() {

        String[] carList;
        int coinNumber;

        gameView.printGetCarNameView();
        carList = readLine().split(",");
        inputValidate(carList);

        gameView.printGetCoinNumberView();
        coinNumber = Integer.parseInt(readLine());

        gameModel.setCarNumber(carList.length);
        gameModel.setCoinNumber(coinNumber);

        setCarModels(carList);
    }

    private void inputValidate(String[] carList) throws IllegalArgumentException {

        for (String carName : carList) {

            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void gamePlay() {

        for (int i = 0; i < gameModel.getCoinNumber(); i++) {

            throwDiceAndGoForward();
        }

        gameView.printDistance(this.carModelList);
    }

    private void throwDiceAndGoForward() {

        int dice;
        ArrayList<CarModel> carModels = getCarModelList();
        CarModel nowCar;

        for (int i = 0; i < gameModel.getCarNumber(); i++) {

            dice = pickNumberInRange(0, 9);
            nowCar = carModels.get(i);

            goForward(nowCar, dice);
        }
    }

    public void setCarModels(String[] carList) {

        for (String carName : carList) {

            carModelList.add(new CarModel(carName));
        }
    }

    public ArrayList<CarModel> getCarModelList() {
        return carModelList;
    }

    public void goForward(CarModel car, int dice) {

        if (dice >= 4) {
            car.goForwardDistance();
        }
    }

    public void findWinner() {

        carModelList.sort(compareCarDistance);
        int size = carModelList.size();
        int mostForwardDistance = carModelList.get(size - 1).getForwardDistance();

        for (CarModel car : carModelList) {

            if (car.getForwardDistance() == mostForwardDistance) {
                gameModel.setWinnerCar(car);
            }
        }
    }

    public void endGame() {

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");

        ArrayList<CarModel> winnerCar = gameModel.getWinnerCar();
        Iterator<CarModel> carModelIterator = winnerCar.iterator();

        while (carModelIterator.hasNext()) {

            sb.append(carModelIterator.next().getName());

            if (carModelIterator.hasNext()) {
                sb.append(", ");
            }
        }

        gameView.printWinner(sb);
    }
}
