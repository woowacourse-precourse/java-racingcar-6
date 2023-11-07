package racingcar.service;

import racingcar.domain.Car;
import racingcar.util.NumberGenerator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.RacingCarGameConstants.FORWARD_CONDITION;

public class RacingGameService {

    private final NumberGenerator randomNumberGenerator;
    private List<Car> carList = new ArrayList<>();

    public RacingGameService(NumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void init(String[] carNamesArr) {
        this.carList = mapToCarList(carNamesArr);
    }

    public void playGame(int count) {
        OutputView.printResultHeader();
        playAndPrintResult(count);
    }

    public String getWinningCar() {
        int maxPosition = getMaxPosition(carList);
        return findWinningCar(maxPosition,carList);
    }

    private List<Car> mapToCarList(String[] carNamesArr) {
        return Arrays.stream(carNamesArr).map(Car::new).toList();
    }

    private void playAndPrintResult(int count) {
        for (int i = 0; i < count; i++) {
            moveCarsAndPrintStatus(carList);
            OutputView.printNewLine();
        }
    }

    private void moveCarsAndPrintStatus(List<Car> carList) {
        for (Car car : carList) {
            if (isForwardPossible()) {
                car.moveForward();
            }
            OutputView.printCarStatus(car);
        }
    }

    private boolean isForwardPossible() {
        return FORWARD_CONDITION <= randomNumberGenerator.generate();
    }

    private String findWinningCar(int maxPosition, List<Car> carList) {
        return getWinningCarNamesAsString(maxPosition, carList);
    }

    private String getWinningCarNamesAsString(int maxPosition, List<Car> carList) {
        return carList.stream().
                filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
