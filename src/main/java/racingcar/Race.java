package racingcar;

import racingcar.car.CarInfo;
import racingcar.car.UserInputCarName;
import racingcar.game.ProcessGame;
import racingcar.game.ResultGame;
import racingcar.game.UserInputGameRound;

import java.util.List;

public class Race {
    public static void run(){
        List<CarInfo> carList = UserInputCarName.getCarList();
        int gameRound = UserInputGameRound.getGameRound();
        ProcessGame.playGame(carList, gameRound);
        ResultGame.printWinner(carList);
    }
}
