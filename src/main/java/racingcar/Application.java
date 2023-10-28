package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        InputView.inputCars(carList);

        int times = InputView.inputTimes();

        int winnerPosition = startRacing(carList, times);

        List<Car> winnerList = new ArrayList<>();
        findWinners(carList, winnerList, winnerPosition);

        OutputView.printWinnerList(winnerList);
    }

    private static int startRacing(List<Car> carList, int times) {

        System.out.println("실행 결과");

        int maxLength = 0;
        while (times-- > 0) {
            maxLength = moveOrStopCar(carList, maxLength);
        }

        return maxLength;
    }

    private static int moveOrStopCar(List<Car> carList, int maxLength) {

        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.moveForward();
                maxLength = Math.max(maxLength, car.getPositionLength());
            }
            OutputView.printCarsPosition(car);
        }

        System.out.println();

        return maxLength;
    }

    private static void findWinners(List<Car> carList, List<Car> winnerList, int winnerPosition) {

        for (Car car : carList) {
            if (car.getPositionLength() == winnerPosition) {
                winnerList.add(car);
            }
        }
    }
}
