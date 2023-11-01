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
    }
}
