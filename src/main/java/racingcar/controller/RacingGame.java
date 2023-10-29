package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private static final Integer ZERO = 0;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Cars cars = Cars.from(inputView.enterCarNames());
        Integer rotateCount = inputView.enterRotateNumber();

        rotate(cars, rotateCount);

        outputView.printWinners(cars.findWinnerNameList());
        Console.close();
    }

    private void rotate(final Cars cars, Integer rotateCount) {
        outputView.printRunResult();

        while (rotateCount-- > ZERO) {
            cars.go();
            outputView.printCarsResults(CarsDto.from(cars));
        }

    }

}
