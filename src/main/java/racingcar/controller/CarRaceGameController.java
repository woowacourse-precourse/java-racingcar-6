package racingcar.controller;

import racingcar.service.AddValueService;
import racingcar.service.CarRaceGameService;
import racingcar.service.FacadeService;
import racingcar.view.InputValues;
import racingcar.view.OutputValues;

import java.util.Arrays;

public class CarRaceGameController {
    public FacadeService facadeService = new FacadeService();
    public InputValues inputValues = new InputValues();
    public OutputValues outputValues = new OutputValues();
    public AddValueService addValueService = new AddValueService();
    public CarRaceGameService carRaceGameService;


    public int tryCount() {
        String count = inputValues.getCount();
        return facadeService.addCarCount(count);

    }

    public String[] addCarNames() {
        String carName = inputValues.getName();
        String[] carNames;
        carNames = facadeService.addCarName(carName);
        return carNames;
    }

    public void play() {
        addCarNames();
        tryCount();

   /* printCarPosition(tryCount(), Arrays.toString(addCarNames()));
        checkWinner();*/
    }

    public void printCarPosition(int count, String carNames) {
        for (int i = 0; i < count; i++) {
            getOutput(count, carNames);
        }
    }

    public void getOutput(int count, String carNames) {
        for (int j = 0; j < addValueService.addCarNames(carNames).length; j++) {
            outputValues.runResultOutput();
            carRaceGameService.carRace(count);
            outputValues.carRaceOutPut(carNames, j);
            carRaceGameService.getPosition(j);
        }
    }

    public void checkWinner(String carNames) {
        outputValues.carRaceWinnerOutput(facadeService.findWinnerName(carNames));
    }
}
