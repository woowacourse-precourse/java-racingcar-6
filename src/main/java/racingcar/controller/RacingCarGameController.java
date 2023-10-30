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
import static racingcar.validation.InputValidator.*;
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

    private List<RacingCar> generateRacingCar(List<String> _carNameList) {
        List<RacingCar> racingCarList = new ArrayList<RacingCar>();

        for(String _carName: _carNameList) {
            racingCarList.add(new RacingCar(_carName));
        }

        return racingCarList;
    }

    public void start() {
        String carNames = inputView.inputCarName();
        Console.println(carNames);

        List<String> carNameList = splitStringToArray(carNames, ",");
        checkValidateCarName(carNameList);
        checkValidateDuplicateCarName(carNameList);
        checkValidateNumOfParticipantCar(carNameList);
        checkValidateContainsGapInCarName(carNameList);

        racingCarGameModel.setCarList(generateRacingCar(carNameList));

        String roundNumber = inputView.inputRoundNumber();
        Console.println(roundNumber);

        checkValidateTypeOfRoundNumber(roundNumber);
        checkValidatePositiveNumber(roundNumber);

        racingCarGameModel.setRoundNumber(parseInt(roundNumber));

        printGameNotice(EXECUTE_RESULT);

        while(racingCarGameModel.getRoundNumber() > 0) {
            round();
        }

        findWinner();
    }

    private void checkValidatePositiveNumber(String _roundNumber) {
        validatePositiveNumber(parseInt(_roundNumber));
    }

    private void checkValidateTypeOfRoundNumber(String _roundNumber) {
        validateTypeOfRoundNumber(_roundNumber);
    }

    private void checkValidateCarName(List<String> _carNameList) {
        for (String _carName: _carNameList) {
            validateCarNameLength(_carName);
        }
    }

    private void checkValidateContainsGapInCarName(List<String> _carNameList) {
        validateContainsGap(_carNameList);
    }

    private void checkValidateDuplicateCarName(List<String> _carNameList) {
        validateDuplicateCarName(_carNameList);
    }


    private void checkValidateNumOfParticipantCar(List<String> _carNameList) {
        validateNumOfParticipantCar(_carNameList);
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

        List<String> winnerList = new ArrayList<String>();

        racingCarList.forEach(_car -> {
            if (_car.getCarMoveCount() == maxCount) {
                winnerList.add(_car.name);
            }
        });

        outputView.printWinner(winnerList);
    }
}
