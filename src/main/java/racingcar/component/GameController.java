package racingcar.component;

import java.util.stream.Collectors;

public class GameController {
    private CarList carList;
    private Inputter inputter;
    private Printer printer;
    private RaceSimulator raceSimulator;
    private int duration;

    public GameController(
            Inputter inputter,
            Printer printer,
            RaceSimulator raceSimulator
            ) {
        this.inputter = inputter;
        this.printer = printer;
        this.raceSimulator = raceSimulator;
    }

    private void initGame() {
        this.carList = new CarList(inputter.getNameInput().stream().map(Car::new)
                .collect(Collectors.toList()));
        this.duration = inputter.getDuration();
    }

}
