package racingcar.controller;

import racingcar.constant.Separator;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.CarNamesInputValidator;
import racingcar.util.CycleInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {
    public GameController() {
    }

    public void start() {
        List<Car> cars = getCarListFromUser();
        int cycle = getCycleFromUser();
        OutputView.lineBreak();

        Game game = new Game(cars);
        OutputView.printRaceResultHeader();
        for(int i=0; i<cycle; i++) {
            game.executeSingleCycleCarMove();
            printCurrentResult(game.getCurrentGameResult());
        }
        List<String> winners = game.getCurrentWinners();
        OutputView.printRaceWinner(winners);
    }

    private List<Car> getCarListFromUser() {
        String carNamesInput = InputView.enterCarNames();
        CarNamesInputValidator.validate(carNamesInput);

        String[] carNameArray = carNamesInput.split(Separator.INPUT_CAR_SEPARATOR.getSeparator());

        List<Car> carList = new ArrayList<>();

        for(String carName :carNameArray) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    private int getCycleFromUser() {
        String cycleInput = InputView.enterCycle();
        CycleInputValidator.validate(cycleInput);

        return Integer.parseInt(cycleInput);
    }

    private void printCurrentResult(Map<String, Integer> result) {
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            OutputView.printSingleCarResult(carName, position);
        }
        OutputView.lineBreak();
    }

}
