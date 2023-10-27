package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
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

    private void playRacingGame(Integer gameCycle, List<Car> cars) {
        OutputManager.printGameStart();
        for (int i = 0; i < gameCycle; i++) {
            for (Car car : cars) {
                int randNumber = Randoms.pickNumberInRange(0, 9);
                car.go(randNumber);
            }
        }
    }


    private Integer getGameCycleNumberFromUser() {
        InputManager.requestGameCycleNumber();
        return Integer.valueOf(Console.readLine());
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
