package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class RacingController {
    private static RacingController racingController;
    private final InputManager inputManager = new InputManager();
    private final OutputManager outputManager = new OutputManager();
    private List<Car> cars;
    private Integer tryCount;

    public RacingController(List<Car> cars, Integer tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }



    public void runRacing(){

    }


}
