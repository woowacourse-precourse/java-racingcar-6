package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameModel;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import utils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static racingcar.contant.GameNotice.EXECUTE_RESULT;
import static racingcar.view.output.OutputView.printGameNotice;
import static utils.StringUtils.splitStringToArray;

public class RacingCarGameController {
    private InputView inputView;
    private OutputView outputView;
    private RacingCarGameModel racingCarGameModel;

    public RacingCarGameController(InputView inputView, OutputView outputView, RacingCarGameModel racingCarGameModel) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarGameModel = racingCarGameModel;
    }

    private List<RacingCar> generateRacingCar(String carNames) {
        List<String> carNameList = splitStringToArray(carNames, ",");
        List<RacingCar> racingCarList = new ArrayList<RacingCar>();

        for(String carName: carNameList) {
            racingCarList.add(new RacingCar(carName));
        }

        return racingCarList;
    }

    public void start() {
        String carNames = inputView.inputCarName();
        Console.println(carNames);

        racingCarGameModel.setCarList(generateRacingCar(carNames));

        String roundNumber = inputView.inputRoundNumber();
        Console.println(roundNumber);

        racingCarGameModel.setRoundNumber(parseInt(roundNumber));

        printGameNotice(EXECUTE_RESULT);

        while(racingCarGameModel.getRoundNumber() > 0) {
            round();
        }

        findWinner();
    }

    private void round() {
        List<RacingCar> racingCarList = racingCarGameModel.getCarList();
        for(RacingCar car: racingCarList) {
            car.moveCar();
            outputView.printMovedCar(car);
        }

        racingCarGameModel.decrementRoundNumber();
    }

    private void findWinner() {
        List<RacingCar> racingCarList = racingCarGameModel.getCarList();

        List<Integer> movedList = new ArrayList<Integer>();
        for(RacingCar car: racingCarList) {
            movedList.add(car.getCarMoveCount());
        }

        int maxCount = Collections.max(movedList);

        racingCarList.stream().filter(
                car -> car.getCarMoveCount() == maxCount
        );

        List<String> winnerList = new ArrayList<String>();

        racingCarList.forEach(car -> winnerList.add(car.name));
        outputView.printWinner(winnerList);
    }
}
