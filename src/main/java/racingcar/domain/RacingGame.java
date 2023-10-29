package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.collection.RacingCars;
import racingcar.domain.interfaces.CarFactory;
import racingcar.domain.interfaces.Game;
import racingcar.util.OutputUtil;

import java.util.List;

public class RacingGame implements Game {

    private final CarFactory factory;

    public RacingGame(CarFactory factory) {
        this.factory = factory;
    }

    @Override
    public void start() {
        RacingCars cars = (RacingCars) factory.createCars();
        progressGameWith(cars);
        showGameResult(cars);
    }

    private void progressGameWith(RacingCars cars) {
        int trial = getTrial();
        for (int i = 0; i < trial; i++) {
            progressOneTrial(cars);
            OutputUtil.printEmptyLine();
        }
    }

    private int getTrial() {
        OutputUtil.printWithLine("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        RacingGameValidator.validateTrial(input);

        return Integer.parseInt(input);
    }
    
    private void progressOneTrial(RacingCars cars) {
        List<RacingCar> currentStatus = cars.getCars();
        currentStatus.forEach(RacingCar::doTrial);
    }

    private void showGameResult(RacingCars cars) {
        cars.showResult();
    }
}
