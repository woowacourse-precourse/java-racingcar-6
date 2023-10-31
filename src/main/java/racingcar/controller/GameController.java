package racingcar.controller;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.ResultView;
import racingcar.view.SettingView;

public class GameController {
    private static final Game game = new Game();
    private static final GameController INSTANCE = new GameController();

    private GameController(){};

    public static GameController getInstance(){
        return INSTANCE;
    }

    public void setGame() {
        setCars();
        setRoundNumber();
        System.out.println();
    }

    public void printResults() {
        ResultView.printResultTitle();
        for (int r = 0; r < game.round; r++) {
            printResultOfRound();
        }
    }

    public void printWinner() {
        ArrayList<String> winnerNameList = getWinnerNameList();
        ResultView.printWinner(winnerNameList);
    }

    public static void setCars() {
        SettingView.printInputCarNameMsg();
        String carNames = Console.readLine();
        setCarList(carNames);
    }

    public static void setRoundNumber() {
        SettingView.printInputRoundNumberMsg();
        String roundNumber = Console.readLine();
        game.round = Integer.parseInt(roundNumber);
    }

    public void printResultOfRound() {
        for (Car car : game.carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
            ResultView.printCarState(car.name, car.position);
        }
        System.out.println();
    }

    public ArrayList<String> getWinnerNameList() {
        ArrayList<String> winnerNameList = new ArrayList<>();
        int max = 0;
        for (Car car : game.carList) {
            if (car.position > max) {
                max = car.position;
                winnerNameList.clear();
            }
            if (car.position == max) {
                winnerNameList.add(car.name);
            }
        }
        return winnerNameList;
    }

    public static void setCarList(String carNames) {
        for (String carName : carNames.split(",")) {
            if (isValidCarName(carName)) game.carList.add(new Car(carName));
        }
    }

    public static boolean isValidCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이내만 가능합니다.");
        }
        return true;
    }
}
