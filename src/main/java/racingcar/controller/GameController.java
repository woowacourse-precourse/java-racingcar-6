package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.RacingGameUtil;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class GameController {

    public void run() {
        String carNames = getCarNameFromUser();
        List<Car> cars = makeCar(carNames);
        Integer gameCycleNumber = getGameCycleNumberFromUser();

        playRacingGame(gameCycleNumber, cars);
    }

    private void playRacingGame(Integer gameCycleNumber, List<Car> cars) {
        RacingGame racingGame = new RacingGame(gameCycleNumber, cars);

        OutputManager.printGameStart();
        racingGame.playGame();
    }

    private Integer getGameCycleNumberFromUser() {
        InputManager.requestGameCycleNumber();
        Integer gameCycleNumber = RacingGameUtil.transferGameCycleType(Console.readLine());
        return gameCycleNumber;
    }

    private List<Car> makeCar(String carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> carNameList = RacingGameUtil.splitCarNames(carNames);
        for (String carName : carNameList) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private String getCarNameFromUser() {
        InputManager.requestCarName();
        return Console.readLine();
    }
}
