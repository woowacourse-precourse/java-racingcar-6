package racingcar.component;

public class GameController {
    private CarList carList;
    private Inputter inputter;
    private Printer printer;
    private RaceSimulator raceSimulator;

    public GameController(
            Inputter inputter,
            Printer printer,
            RaceSimulator raceSimulator
            ) {
        this.inputter = inputter;
        this.printer = printer;
        this.raceSimulator = raceSimulator;
    }

}
