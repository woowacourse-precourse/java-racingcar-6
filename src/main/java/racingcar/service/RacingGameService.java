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

    public void init(String[] carNamesArr) {
        this.carList = mapToCarList(carNamesArr);
    }

    private List<Car> mapToCarList(String[] carNamesArr) {
        return Arrays.stream(carNamesArr).map(n -> new Car(n)).toList();
    }

    public void playGame(int count) {
        OutputView.printResultHeader();
        for (int i = 0; i < count; i++) {
            play(carList);
            OutputView.printNewLine();
        }

    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            if (canMoveForward()) {
                car.moveForward();
            }
            OutputView.printCarStatus(car);
        }
    }

    private boolean canMoveForward() {
        return FORWARD_CONDITION <= randomNumberGenerator.generate();
    }

    public String getWinningCar() {
        int maxPosition = getMaxPosition(carList);
        return findWinningCar(maxPosition,carList);
    }

    private String findWinningCar(int maxPosition, List<Car> carList) {
        return getWinningCarNamesAsString(maxPosition, carList);
    }

    private String getWinningCarNamesAsString(int maxPosition, List<Car> carList) {
        return carList.stream().filter(c -> c.getPosition() == maxPosition)
                .map(c -> c.getName()).collect(Collectors.joining(", "));
    }

    private int getMaxPosition(List<Car> carList) {
        int max = 0;
        for (Car car : carList) {
            int position = car.getPosition();
            if(position > max){
                max = position;
            }
        }
        return max;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
