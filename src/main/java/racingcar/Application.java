package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputCarNames = Input.inputCarName();
        List<String> carNames = Car.splitByComma(inputCarNames);
        System.out.println(inputCarNames);
        System.out.println(carNames);
    }
}
