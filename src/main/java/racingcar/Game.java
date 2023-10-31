package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private final GameShow gameShow = new GameShow();
    private final CarUtil carUtil = new CarUtil();


    public void play() {
        gameShow.show(gameShow.inputNameMessage);
        List<Car> cars = carUtil.parseCarName(Console.readLine());

        gameShow.show(gameShow.inputTimeMessage);
        int time = Integer.parseInt(Console.readLine());

        gameShow.show(gameShow.executeMessage);
        for(int i = 0; i < time; i++) {
            gameProceed(cars);
            gameShow.ProgressShow(cars);
        }

        gameShow.gameResult(cars);
    }

    public void gameProceed(List<Car> cars) {
        for(Car car : cars) {
            carUtil.process(car);
        }
    }

}
