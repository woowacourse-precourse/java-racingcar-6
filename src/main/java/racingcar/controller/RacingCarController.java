package racingcar.controller;

import racingcar.car.CarListMaker;
import racingcar.output.OutputController;

public class RacingCarController {
    OutputController outputController = new OutputController();
    public void start() {
        outputController.printCarNameInputMessage();
        CarListMaker carListMaker = new CarListMaker();
        List<String> carList = carListMaker.makeCarList();

        outputController.printTryingCountsInputMessage();
        TryingCounts tryingCounts = new TryingCounts();
        Integer tryingCountsNumber = tryingCounts.getTryingCounts();

        CarMovingController carMovingController = new CarMovingController();
        String racingCarResult = carMovingController.moveCars(carList,tryingCountsNumber);

        outputController.printResult(racingCarResult);
    }
}
