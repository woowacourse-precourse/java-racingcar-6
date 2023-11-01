package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;
import racingcar.result.Result;
import racingcar.config.Config;
import racingcar.printer.GamePrinter;
import racingcar.scanner.GameScanner;

public class RacingGame {

    private final GamePrinter printer;
    private final GameScanner<List<String>> nameScanner;
    private final GameScanner<Integer> numberScanner;

    private List<RacingCar> racingCars;
    private int numberOfTimes;

    public RacingGame() {
        Config config = new Config();

        this.printer = config.getPrinter();
        this.nameScanner = config.getNameScanner();
        this.numberScanner = config.getNumberScanner();
    }

    public void start() {
        setRacingCarsWithNames();
        setNumberOfTimes();

        printer.printNewLine();
    }

    private void setRacingCarsWithNames() {
        printer.printRacingCarNameMessage();
        List<String> racingCarNames = nameScanner.scan();
        racingCars = racingCarNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private void setNumberOfTimes() {
        printer.printNumberOfTimesMessage();
        numberOfTimes = numberScanner.scan();
    }

    public void play() {
        Result roundResult = null;

        for (int round = 0; round < numberOfTimes; round++) {
            roundResult = race();
            printer.printResult(roundResult, round);
        }

        // round는 항상 0보다 크기 때문에 roundResult가 null이 아님이 보장된다.
        finishRace(roundResult);
    }

    private Result race() {
        Result result = new Result();

        for (RacingCar racingCar : racingCars) {
            racingCar.move();
            result.add(racingCar);
        }

        return result;
    }

    private void finishRace(Result roundResult) {
        Result winners = roundResult.findWinners();
        printer.printWinnersName(winners.getNames());
    }

    public void end() {
        GameScanner.close();
    }
}
