package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start(){
        outputView.printRacingCarNameInputMessage();
        String[] carNames = inputView.readRacingCarName();

        outputView.printNumberOfTryInputMessage();
        int numberOfTry = inputView.readNumberOfTry();

        List<RacingCar> racingCars = new ArrayList<>();

        for(int i = 0; i < carNames.length; i++){
            racingCars.add(new RacingCar(carNames[i]));
        }

        for(int i = 0; i < numberOfTry; i++){
            for(int k = 0; k < racingCars.size(); k++){
                racingCars.get(k).moveRandom(numberGenerator.generateNumber());
            }
            outputView.printResult(racingCars);
        }

        outputView.printWinner();
    }
}
