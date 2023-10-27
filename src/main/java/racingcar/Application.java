package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Car car = new Car();
        Validator validator = new Validator();

        /*String inputCarNames = input.inputCarName();
        List<String> carNames = car.splitByComma(inputCarNames);
        System.out.println(inputCarNames);
        System.out.println(carNames);*/

        String inputNumber = input.inputTryNumber();
        validator.isNumber(inputNumber);
    }
}
