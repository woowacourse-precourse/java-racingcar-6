package racingcar;

import java.util.ArrayList;
import java.util.List;
import view.InputView;

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
    }
}
