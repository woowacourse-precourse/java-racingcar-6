package racingcar;

import racingcar.car.CarInfo;
import racingcar.car.UserInputCarName;
import racingcar.game.processGame;
import racingcar.game.UserInputGameRound;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<CarInfo> carList = UserInputCarName.getCarList();
        int gameRound = UserInputGameRound.getGameRound();
        processGame.playGame(carList, gameRound);
    }
}