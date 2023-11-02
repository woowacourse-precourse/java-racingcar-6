package racingcar.controller;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.RacingCarView;

public class RacingGame {
    private CarRepository carRepository = CarRepository.getInstance();
    private RacingCarView view = new RacingCarView();
    RacingCarGenerateController carGenerate = new RacingCarGenerateController();
    CarRacingController carRacing = new CarRacingController();
    private int racingCount;

    public void gameStart() {
        //input
        carGenerate.generateCar(view.inputCarName());
        racingCount = carGenerate.setRacingCount(view.inputCount());

        //output
        carRacing.setRacingResults(racingCount);
        carRacing.printWinner();
    }

}
