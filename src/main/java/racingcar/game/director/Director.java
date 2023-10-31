package racingcar.game.director;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.game.car.Car;
import racingcar.game.car.CarFactory;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

public class Director {

    private final InputGenerateManager inputGenerateManager;
    private final OutputGenerateManager outputGenerateManager;
    private final Simulator simulator;
    private final CarFactory carFactory;

    public Director(InputGenerateManager inputGenerateManager, OutputGenerateManager outputGenerateManager,
                    Simulator simulator, CarFactory carFactory) {
        this.inputGenerateManager = inputGenerateManager;
        this.outputGenerateManager = outputGenerateManager;
        this.simulator = simulator;
        this.carFactory = carFactory;
    }

    public void startProcess() {
        List<Car> cars = this.insertName();
        Integer integerRepeatCount = this.insertCount();
        this.showResult(cars, integerRepeatCount);
        this.close();
    }

    private void showResult(List<Car> cars, Integer integerRepeatCount) {
        outputGenerateManager.printResultAnnounce();
        this.repeatRound(cars, integerRepeatCount);
        outputGenerateManager.printWinnerAnnounce();
        outputGenerateManager.printWinners(cars);
    }

    private Integer insertCount() {
        outputGenerateManager.printRepeatCountAnnounce();
        String StringRepeatCount = this.readLine();
        Integer integerRepeatCount = inputGenerateManager.generateInputStringToInt(StringRepeatCount);
        return integerRepeatCount;
    }

    private List<Car> insertName() {
        outputGenerateManager.printCarNameAnnounce();
        String rawString = this.readLine();
        List<String> racingCarNameList = inputGenerateManager.generateInputStringSplitWithComma(rawString);
        List<Car> cars = carFactory.createCars(racingCarNameList);
        return cars;
    }

    private String readLine() {
        return Console.readLine();
    }

    private void close() {
        Console.close();
    }

    private void repeatRound(List<Car> cars, Integer integerRepeatCount) {
        for (int i = 0; i < integerRepeatCount; i++) {
            Round round = simulator.perRound(cars);
            outputGenerateManager.printResultList(round);
        }
    }
}
