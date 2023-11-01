package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;

public class GameInputController {
    private InputView inputView;
    private Cars cars;
    private Game game;

    public void settingController() {
       inputView = new InputView();
       cars = new Cars();
       game = new Game(cars);
    }

    public Game sendGameInfo() {
        return game;
    }

    /**
     * 이 메서드는 Controller 테스트에서만 사용되는 코드입니다.
     * @return ArrayList<Car>
     */
    public ArrayList<Car> getListOfCar() {
        return cars.getCarList();
    }

    /**
     * 이 메서드는 Controller 테스트에서만 사용되는 코드입니다.
     * @return int
     */
    public int getTryNumberOfGame() {
        return game.getChanceNumber();
    }

    public void requestNames() {
        String names = inputView.requestNames();
        cars.settingNames(names);
    }

    public void requestTryNumber() {
        String tryChance = inputView.requestTryNumber();
        game.settingChance(tryChance);
    }

}
