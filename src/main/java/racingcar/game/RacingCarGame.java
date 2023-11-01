package racingcar.game;

import racingcar.domain.CarList;
import racingcar.domain.TryCount;
import racingcar.innout.InputPrint;
import racingcar.innout.OutputPrint;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RacingCarGame {

    private final InputPrint inputPrint;
    private final OutputPrint outputPrint;

    public RacingCarGame() {
        outputPrint = new OutputPrint();
        inputPrint = new InputPrint(outputPrint);
    }

    public void run() {
        CarList cars = repeat(inputPrint::inputCarName);
        TryCount tryCount = repeat(inputPrint::inputTryCount);

        moveAllCar(cars, tryCount);

        printWinner(cars);
    }

    private void moveAllCar(CarList cars, TryCount tryCount) {
        outputPrint.printRacingStart();
        IntStream.range(0, tryCount.getCount()).forEach(index -> {
            cars.moveAll();
            outputPrint.printRacingLog(cars);
        });
    }

    private void printWinner(CarList cars) {
        outputPrint.printWinner(cars);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(inputReader);
        }
    }
}
