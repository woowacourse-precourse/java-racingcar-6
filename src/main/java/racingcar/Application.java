package racingcar;

import java.util.List;
import racingcar.controller.Game;
import racingcar.service.CarMove;
import racingcar.service.CarName;
import racingcar.service.RandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        CarName carName = new CarName();
        RandomNumber randomNumber = new RandomNumber();
        CarMove carMove = new CarMove(carName, randomNumber);
        Game game = new Game(carMove, carName, randomNumber);

        game.start();

    }

}


