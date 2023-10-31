package racingcar.component.controller;

import java.util.stream.Collectors;
import racingcar.component.service.Inputter;
import racingcar.component.service.Printer;
import racingcar.component.service.RaceSimulator;
import racingcar.component.domain.Car;
import racingcar.component.vo.CarList;

public class GameController {
    private CarList carList;
    private Inputter inputter;
    private Printer printer;
    private RaceSimulator raceSimulator;
    private int duration;

    public GameController(
            Inputter inputter,
            Printer printer
            ) {
        this.inputter = inputter;
        this.printer = printer;
        this.raceSimulator = RaceSimulator.getRaceSimulator(printer);
    }

    public void startGame() {
        initGame();
        doGame();
    }

    private void doGame() {
        raceSimulator.simulate(this.carList.getCarList(), this.duration);
        printer.printWinner(this.carList.getCarList());
    }

    private void initGame() {
        this.carList = new CarList(inputter.getNameInput().stream().map(Car::new)
                .collect(Collectors.toList()));
        this.duration = inputter.getDuration();
    }

}
