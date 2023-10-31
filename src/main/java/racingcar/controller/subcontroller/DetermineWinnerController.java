package racingcar.controller.subcontroller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.util.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class DetermineWinnerController {
    private final InputView inputView;
    private final OutputView outputView;

    public DetermineWinnerController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void determineWinner() {
        int maxCount = getMaxCount();
        List<String> winners = getWinners(maxCount);
        outputWinner(winners);
    }

    private void outputWinner(List<String> winners) {
        outputView.outputWinner(winners);
    }

    private List<String> getWinners(int maxCount) {
        return CarRepository.cars()
                .stream()
                .filter(car -> Util.isEqual(maxCount, car.getMoveCount()))
                .map(Car::getName)
                .toList();
    }

    private int getMaxCount() {
        int maxCount = -1;
        for (Car car : CarRepository.cars()) {
            maxCount = Math.max(car.getMoveCount(), maxCount);
        }
        return maxCount;
    }
}
