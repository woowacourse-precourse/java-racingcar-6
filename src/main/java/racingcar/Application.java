package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        String[] names = InputView.inputCarNames();
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        int testNumber = InputView.inputTestNumber();

        if (testNumber < 0) {
            throw new IllegalArgumentException("숫자 입력은 양수만 가능합니다.");
        }

        OutputView.printResult();
        for (int i = 0; i < testNumber; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
                OutputView.printCarInfo(car);
            }
            OutputView.printNewLine();
        }

        List<Car> winnerCars = getWinnerCars(cars);

        OutputView.printWinner(winnerCars);
    }

    private static List<Car> getWinnerCars(List<Car> cars) {
        int max = findMax(cars);

        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }

    private static int findMax(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }
}
