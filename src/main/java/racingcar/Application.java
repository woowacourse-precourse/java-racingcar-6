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

        carList.forEach(car -> {
            car.moveOrStop(new RandomRaceNumberGenerator());
            OutputView.printCarsPosition(car);
        });

        System.out.println();
    }

    private static int getWinnerPosition(List<Car> carList) {

        return carList.stream()
                .mapToInt(Car::getPositionLength)
                .max()
                .orElse(0);
    }

    private static void findWinners(List<Car> carList, List<Car> winnerList, int winnerPosition) {

        carList.stream().filter(car -> car.getPositionLength() == winnerPosition).forEach(winnerList::add);
    }
}
