package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGameService {

    private List<Car> carList = new ArrayList<>();

    public void init(String[] carNamesArr) {
        this.carList = mapToCarList(carNamesArr);
    }

    private List<Car> mapToCarList(String[] carNamesArr) {
        return Arrays.stream(carNamesArr).map(n -> new Car(n)).toList();
    }

    public void playGame(int count) {
        OutputView.printResult();
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
            OutputView.printCarPosition(car);
        }
    }

    private boolean canMoveForward() {
        return 4 <= Randoms.pickNumberInRange(0, 9);
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


}
