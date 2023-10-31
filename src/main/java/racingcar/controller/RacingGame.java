package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerNameDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private static final int ZERO = 0;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Cars cars = Cars.of(inputView.enterCarNames(), new RandomNumberGenerator());
        int rotateCount = inputView.enterRotateNumber();

        rotate(cars, rotateCount);

        outputView.printWinners(WinnerNameDto.from(cars.findWinnerCarList()));
        Console.close();
    }

    private void rotate(final Cars cars, int rotateCount) {
        outputView.printRunResult();

        while (rotateCount-- > ZERO) {
            cars.goByNumber();
            outputView.printCarsResults(CarsDto.from(cars));
        }

    }

}
