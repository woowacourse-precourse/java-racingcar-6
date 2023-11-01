package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.style.DistanceStyle;
import racingcar.util.style.DistanceStyleFactory;
import racingcar.util.style.DistanceStyles;
import racingcar.view.car.CarView;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import racingcar.vo.CarList;
import racingcar.vo.CarListFactory;

public class GameControllerImpl implements GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final List<CarView> carViewList;

    public GameControllerImpl(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;

        carViewList = new ArrayList<>();
    }

    @Override
    public void run() {
        final CarList carList = getCarList();
        createCarViews(carList);
        final int tryCount = getTryCount();
        outputView.printNewLine();
        printExecutionResult(tryCount, carList);
        printWinners(carList);
        Console.close();
    }

    public CarList getCarList() {
        outputView.printInputCarNameMessage();
        final String carNames = inputView.readCarNames();
        final CarList carList = CarListFactory.create(carNames);
        return carList;
    }

    public void createCarViews(CarList carList) {
        final DistanceStyle dashDistanceStyle = DistanceStyleFactory.create(DistanceStyles.DASH);
        carList.getCarList()
                .stream()
                .map(car -> new CarView(car, outputView, dashDistanceStyle))
                .forEach(carViewList::add);
    }

    public int getTryCount() {
        outputView.printInputTryCountMessage();
        final int tryCount = inputView.readTryCount();
        return tryCount;
    }

    public void printExecutionResult(final int tryCount, final CarList carList) {
        outputView.printExecutionResult();
        for (int i = 0; i < tryCount; i++) {
            carList.moveForward();
            outputView.printNewLine();
        }
    }

    public void printWinners(final CarList carList) {
        final String winners = carList.getWinners();
        outputView.printWinnersFromCarList(winners);
    }
}
