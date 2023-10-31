package racingcar;

import java.util.List;

public class RacingGame {

    private int count;
    private RacingCars racingCars;

    private InputView inputView;
    private OutputView outputView;

    public void start() {

        inputView = new InputView();
        outputView = new OutputView();

        String[] carNames = inputView.readCarNames();

        racingCars = new RacingCars();

        for (String carName : carNames) {
            validateCarName(carName);
            racingCars.add(new RacingCar(carName));
        }

        count = inputView.readCount();

        outputView.printResult(count, racingCars);
        outputView.printWinners(racingCars.getWinners());
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
