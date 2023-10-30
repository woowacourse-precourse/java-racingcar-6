package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.RandomRaceNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        InputView.inputCars(carList);

        int times = InputView.inputTimes();

        startRacing(carList, times);

        int winnerPosition = getWinnerPosition(carList);

        List<Car> winnerList = new ArrayList<>();
        findWinners(carList, winnerList, winnerPosition);

        OutputView.printWinnerList(winnerList);
    }

    private static void startRacing(List<Car> carList, int times) {

        System.out.println("실행 결과");

        while (times-- > 0) {
            moveOrStopCar(carList);
        }
    }

    public static void moveOrStopCar(List<Car> carList) {

        for (Car car : carList) {
            car.moveOrStop(new RandomRaceNumberGenerator());
            OutputView.printCarsPosition(car);
        }

        System.out.println();
    }

    private static int getWinnerPosition(List<Car> carList) {

        int winnerPosition = 0;
        for (Car car : carList) {
            winnerPosition = Math.max(winnerPosition, car.getPositionLength());
        }

        return winnerPosition;
    }

    private static void findWinners(List<Car> carList, List<Car> winnerList, int winnerPosition) {

        for (Car car : carList) {
            if (car.getPositionLength() == winnerPosition) {
                winnerList.add(car);
            }
        }
    }
}
